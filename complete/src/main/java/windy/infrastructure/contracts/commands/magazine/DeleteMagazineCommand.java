package windy.infrastructure.contracts.commands.magazine;

import java.util.UUID;

public class DeleteMagazineCommand extends MagazineCommand {

	public DeleteMagazineCommand(UUID uid) {
		super(uid);
	}
}
