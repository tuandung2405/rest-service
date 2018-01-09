package windy.infrastructure.contracts.commands.magazine;

import java.util.UUID;

import windy.framework.contracts.Command;

public class MagazineCommand extends Command {

	public MagazineCommand(UUID uid) {
		super(uid);
	}
}
