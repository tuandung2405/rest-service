package windy.infrastructure.commandhandlers.magazineimpl;

import org.springframework.beans.factory.annotation.Autowired;

import windy.infrastructure.commandhandlers.MagazineCommandHandler;
import windy.infrastructure.contracts.commands.magazine.CreateMagazineCommand;
import windy.infrastructure.domains.Magazine;
import windy.infrastructure.reposistories.MagazineRepository;

public class CreateMagazineCommandHandler extends MagazineCommandHandler<CreateMagazineCommand> {

	@Autowired
	public CreateMagazineCommandHandler(MagazineRepository MagazineRepository) {
		super(MagazineRepository);
	}

	@Override
	public void handle(CreateMagazineCommand command) {
		Magazine m = new Magazine(command.getUid());
		m.setTitle(command.getTitle());
		m.setAuthor(command.getAuthor());
		m.setCount(1);
		m.setCreatedAt(System.currentTimeMillis());
		m.setPublishedDate(System.currentTimeMillis());
		m.setActive(true);

		getMagazineRepository().create(m);
	}
}
