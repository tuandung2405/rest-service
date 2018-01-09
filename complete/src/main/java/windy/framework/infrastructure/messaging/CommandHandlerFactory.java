package windy.framework.infrastructure.messaging;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import windy.framework.contracts.Command;
import windy.framework.core.messaging.ICommandHandler;
import windy.framework.core.messaging.ICommandHandlerFactory;

@Controller
public class CommandHandlerFactory implements ICommandHandlerFactory {

	private static CommandHandlerFactory instance = null;
	private HashMap<String, String> handlerMap;

	@Autowired
	Command command;

	public CommandHandlerFactory(Command command) {
		this.command = command;
	}

	@Override
	public <T extends Command> ICommandHandler<T> createCommandHandler(T command) {
		 String[] classNames = command.getClass().getName().split("\\.");
		 //ICommandHandler<T> handler = parseHandlerClass(classNames[classNames.length - 1]);
		 return null;
	}
	
	private String parseHandlerClass(String cmnName) {

		return cmnName + "Handler";
	}
}
