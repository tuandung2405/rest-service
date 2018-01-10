package windy.framework.infrastructure.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import windy.framework.contracts.Command;
import windy.framework.core.messaging.ICommanBus;
import windy.framework.core.messaging.ICommandHandlerFactory;

@Scope("singleton")
public class CommandBus implements ICommanBus {
	
	ICommandHandlerFactory commandHandlerFactory;
	
	@Autowired
	public CommandBus(ICommandHandlerFactory commandHandlerFactory) {
		this.commandHandlerFactory = commandHandlerFactory;
	}

	@Override
	@Autowired
	public <T extends Command> void send(T command) {
		commandHandlerFactory.createCommandHandler(command).handle(command);
	}
}
