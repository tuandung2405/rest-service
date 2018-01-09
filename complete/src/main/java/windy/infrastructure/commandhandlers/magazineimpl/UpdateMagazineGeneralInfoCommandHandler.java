package windy.infrastructure.commandhandlers.magazineimpl;

import windy.infrastructure.commandhandlers.MagazineCommandHandler;
import windy.infrastructure.contracts.commands.magazine.UpdateMagazineGeneralInfoCommand;
import windy.infrastructure.domains.Magazine;
import windy.infrastructure.reposistories.MagazineRepository;

public class UpdateMagazineGeneralInfoCommandHandler extends MagazineCommandHandler<UpdateMagazineGeneralInfoCommand> {

	public UpdateMagazineGeneralInfoCommandHandler(MagazineRepository MagazineRepository) {
		super(MagazineRepository);
	}

	@Override
	public void handle(UpdateMagazineGeneralInfoCommand command) {
		Magazine m = getMagazineRepository().getById(command.getUid());
		if (m != null) {
			m.setTitle(command.getTitle());
			m.setAuthor(command.getAuthor());

			getMagazineRepository().update(m);
		}
	}

}
