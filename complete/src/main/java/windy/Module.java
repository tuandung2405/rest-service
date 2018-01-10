
package windy;

import com.google.inject.AbstractModule;

import windy.framework.core.messaging.ICommandHandlerFactory;
import windy.framework.infrastructure.messaging.CommandHandlerFactory;

public class Module extends AbstractModule {

	@Override
	protected void configure() {
		bind(ICommandHandlerFactory.class).to(CommandHandlerFactory.class);
	}
}
