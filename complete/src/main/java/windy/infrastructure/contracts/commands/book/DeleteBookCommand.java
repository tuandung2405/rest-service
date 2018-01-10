package windy.infrastructure.contracts.commands.book;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class DeleteBookCommand extends BookCommand {

	public DeleteBookCommand(UUID uid) {
		super(uid);
	}
}
