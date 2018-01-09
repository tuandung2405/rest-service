package windy.infrastructure.commandhandlers.magazineimpl;

import windy.infrastructure.commandhandlers.MagazineCommandHandler;
import windy.infrastructure.contracts.commands.magazine.UpdateMagazineCommand;
import windy.infrastructure.domains.Magazine;
import windy.infrastructure.reposistories.MagazineRepository;

public class UpdateMagazineCommandHandler extends MagazineCommandHandler<UpdateMagazineCommand> {

	public UpdateMagazineCommandHandler(MagazineRepository MagazineRepository) {
		super(MagazineRepository);
	}

	@Override
	public void handle(UpdateMagazineCommand command) {
		Magazine m = getMagazineRepository().getById(command.getUid());
		if (m != null) {
			m.setTitle(command.getTitle());
			m.setAuthor(command.getAuthor());

			getMagazineRepository().update(m);
		}
	}

}
