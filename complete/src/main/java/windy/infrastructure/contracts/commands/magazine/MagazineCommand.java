package windy.infrastructure.contracts.commands.magazine;

import java.util.UUID;

import org.springframework.stereotype.Component;

import windy.framework.contracts.Command;

@Component
public class MagazineCommand extends Command {

	public MagazineCommand(UUID uid) {
		super(uid);
	}
}
