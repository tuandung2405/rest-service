package windy.infrastructure.commandhandlers.magazineimpl;

import org.springframework.beans.factory.annotation.Autowired;

import windy.infrastructure.commandhandlers.MagazineCommandHandler;
import windy.infrastructure.contracts.commands.magazine.DeleteMagazineCommand;
import windy.infrastructure.reposistories.MagazineRepository;

public class DeleteMagazineCommandHandler extends MagazineCommandHandler<DeleteMagazineCommand>{
	
	@Autowired
	public DeleteMagazineCommandHandler(MagazineRepository magazineRepository) {
		super(magazineRepository);
	}

	@Override
	public void handle(DeleteMagazineCommand command) {
		getMagazineRepository().delete(command.getUid());
	}

}
