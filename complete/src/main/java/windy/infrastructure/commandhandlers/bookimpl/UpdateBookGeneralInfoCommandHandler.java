package windy.infrastructure.commandhandlers.bookimpl;

import windy.infrastructure.commandhandlers.BookCommandHandler;
import windy.infrastructure.contracts.commands.book.UpdateBookGeneralInfoCommand;
import windy.infrastructure.domains.Book;
import windy.infrastructure.reposistories.BookRepository;

public class UpdateBookGeneralInfoCommandHandler extends BookCommandHandler<UpdateBookGeneralInfoCommand> {

	public UpdateBookGeneralInfoCommandHandler(BookRepository bookRepository) {
		super(bookRepository);
	}

	@Override
	public void handle(UpdateBookGeneralInfoCommand command) {
		Book b = getBookRepository().getById(command.getUid());
		if (b != null) {
			b.setTitle(command.getTitle());
			b.setAuthor(command.getAuthor());

			getBookRepository().update(b);
		}
	}

}
