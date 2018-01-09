package windy.api.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import windy.framework.core.messaging.ICommanBus;
import windy.framework.infrastructure.messaging.CommandBus;
import windy.infrastructure.contracts.commands.book.CreateBookCommand;
import windy.infrastructure.contracts.commands.book.DeleteBookCommand;
import windy.infrastructure.contracts.commands.book.UpdateBookGeneralInfoCommand;
import windy.infrastructure.domains.Book;
import windy.infrastructure.reposistories.BookRepository;

@Controller
public class BookController {

	private ICommanBus commandBus;
    private BookRepository bookRepository;
	
	public BookController(CommandBus commandBus, BookRepository bookRepository) {
		this.commandBus = commandBus;
		this.bookRepository = bookRepository;
	}
	
	@RequestMapping(value="book", method=RequestMethod.GET)
	public List<Book> getAll() {
		return bookRepository.getAll();
	}
	
	@RequestMapping(value="book/{id}", method=RequestMethod.GET)
	public Book getBookById(@RequestBody UUID _id) {
		return bookRepository.getById(_id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void create(@RequestBody Book book) {
		CreateBookCommand createBookCommand = new CreateBookCommand(book.getUid(), book.getTitle(), book.getAuthor());
		commandBus.send(createBookCommand);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void updateGeneralInfo(@RequestBody Book book) {
		UpdateBookGeneralInfoCommand updateBookCommand = new UpdateBookGeneralInfoCommand(book.getUid(), book.getTitle(), book.getAuthor());
		commandBus.send(updateBookCommand);
	}
	
	@RequestMapping(value="book/{id}", method=RequestMethod.DELETE)
	public void delete(@RequestBody UUID _id) {
		DeleteBookCommand deleteBookCommand = new DeleteBookCommand(_id);
		commandBus.send(deleteBookCommand);
	}
}
