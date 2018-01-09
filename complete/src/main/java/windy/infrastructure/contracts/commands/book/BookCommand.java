package windy.infrastructure.contracts.commands.book;

import java.util.UUID;

import windy.framework.contracts.Command;

public class BookCommand extends Command {

	public BookCommand(UUID uid) {
		super(uid);
	}
}
