package windy.infrastructure.commandhandlers;


import windy.framework.core.messaging.ICommandHandler;
import windy.infrastructure.contracts.commands.book.BookCommand;
import windy.infrastructure.reposistories.BookRepository;

public abstract class BookCommandHandler<T extends BookCommand> implements ICommandHandler<T> {

	private BookRepository bookRepository;
	
	public BookCommandHandler(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public BookRepository getBookRepository() {
		return bookRepository;
	}

}
