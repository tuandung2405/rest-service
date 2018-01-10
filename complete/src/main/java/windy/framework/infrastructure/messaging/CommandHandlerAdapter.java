package windy.framework.infrastructure.messaging;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import windy.framework.contracts.Command;
import windy.infrastructure.commandhandlers.BookCommandHandler;
import windy.infrastructure.commandhandlers.bookimpl.CreateBookCommandHandler;
import windy.infrastructure.commandhandlers.bookimpl.DeleteBookCommandHandler;
import windy.infrastructure.commandhandlers.bookimpl.UpdateBookCommandHandler;
import windy.infrastructure.contracts.commands.book.CreateBookCommand;
import windy.infrastructure.contracts.commands.book.DeleteBookCommand;
import windy.infrastructure.contracts.commands.book.UpdateBookCommand;

@Component
public class CommandHandlerAdapter {

	@Autowired
	private CreateBookCommandHandler createBookCommandHandler;

	@Autowired
	private UpdateBookCommandHandler updateBookCommandHandler;

	@Autowired
	private DeleteBookCommandHandler deleteBookCommandHandler;

	public <T extends Command> BookCommandHandler<?> getCommand(Class<T> command) {
		if(CreateBookCommand.class.isAssignableFrom(command))
			return createBookCommandHandler;
		else if(UpdateBookCommand.class.isAssignableFrom(command))
			return updateBookCommandHandler;
		else if(DeleteBookCommand.class.isAssignableFrom(command))
			return deleteBookCommandHandler;
		return null;
	}
}
