package windy.infrastructure.commandhandlers;

import windy.framework.core.messaging.ICommandHandler;
import windy.infrastructure.contracts.commands.magazine.MagazineCommand;
import windy.infrastructure.reposistories.MagazineRepository;

public abstract class MagazineCommandHandler<T extends MagazineCommand> implements ICommandHandler<T>{

	private MagazineRepository magazineRepository;
	
	public MagazineCommandHandler(MagazineRepository magazineRepository) {
		this.magazineRepository = magazineRepository;
	}
	
	public MagazineRepository getMagazineRepository() {
		return magazineRepository;
	}

}
