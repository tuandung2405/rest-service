package windy.infrastructure.contracts.commands.book;

import java.util.UUID;

import org.springframework.stereotype.Component;

import windy.framework.contracts.Command;

@Component
public class BookCommand extends Command {

	public BookCommand(UUID uid) {
		super(uid);
	}
}
