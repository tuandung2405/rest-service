package windy.infrastructure.commandhandlers.bookimpl;

import windy.infrastructure.commandhandlers.BookCommandHandler;
import windy.infrastructure.contracts.commands.book.CreateBookCommand;
import windy.infrastructure.domains.Book;
import windy.infrastructure.reposistories.BookRepository;

public class CreateBookCommandHandler extends BookCommandHandler<CreateBookCommand> {

	public CreateBookCommandHandler(BookRepository bookRepository) {
		super(bookRepository);
	}

	@Override
	public void handle(CreateBookCommand command) {
		Book b = new Book(command.getUid());
		b.setTitle(command.getTitle());
		b.setAuthor(command.getAuthor());
		b.setCount(1);
		b.setCreatedAt(System.currentTimeMillis());
		b.setPublishedDate(System.currentTimeMillis());
		b.setActive(true);

		getBookRepository().create(b);
	}
}
