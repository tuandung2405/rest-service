package windy.infrastructure.contracts.commands.book;

import java.util.UUID;

public class DeleteBookCommand extends BookCommand {

	public DeleteBookCommand(UUID uid) {
		super(uid);
	}
}
