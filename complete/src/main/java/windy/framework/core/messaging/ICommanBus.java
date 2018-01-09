package windy.framework.core.messaging;


import windy.framework.contracts.Command;

public interface ICommanBus {

	public <T extends Command> void send(T command);
}
