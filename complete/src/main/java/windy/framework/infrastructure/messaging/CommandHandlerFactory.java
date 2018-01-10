package windy.framework.infrastructure.messaging;

import windy.framework.contracts.Command;
import windy.framework.core.messaging.ICommandHandler;
import windy.framework.core.messaging.ICommandHandlerFactory;

public class CommandHandlerFactory implements ICommandHandlerFactory {

	
	CommandHandlerAdapter adapter;

	public CommandHandlerFactory(CommandHandlerAdapter adapter) {
		this.adapter = adapter;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Command> ICommandHandler<T> createCommandHandler(T command) {
		return (ICommandHandler<T>) this.adapter.getCommand(command.getClass());
	}
}
