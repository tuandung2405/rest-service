package windy.infrastructure.commandhandlers.bookimpl;

import windy.infrastructure.commandhandlers.BookCommandHandler;
import windy.infrastructure.contracts.commands.book.UpdateBookCommand;
import windy.infrastructure.domains.Book;
import windy.infrastructure.reposistories.BookRepository;

public class UpdateBookCommandHandler extends BookCommandHandler<UpdateBookCommand> {

	public UpdateBookCommandHandler(BookRepository bookRepository) {
		super(bookRepository);
	}

	@Override
	public void handle(UpdateBookCommand command) {
		Book b = getBookRepository().getById(command.getUid());
		if (b != null) {
			b.setTitle(command.getTitle());
			b.setAuthor(command.getAuthor());

			getBookRepository().update(b);
		}
	}

}
