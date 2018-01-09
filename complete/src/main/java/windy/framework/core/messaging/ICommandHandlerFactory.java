package windy.framework.core.messaging;

import windy.framework.contracts.Command;

public interface ICommandHandlerFactory {

	public <T extends Command> ICommandHandler<T> createCommandHandler(T command);
}