package windy.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import windy.framework.core.messaging.ICommanBus;
import windy.framework.infrastructure.messaging.CommandBus;
import windy.infrastructure.contracts.commands.magazine.CreateMagazineCommand;
import windy.infrastructure.contracts.commands.magazine.DeleteMagazineCommand;
import windy.infrastructure.contracts.commands.magazine.UpdateMagazineGeneralInfoCommand;
import windy.infrastructure.domains.Magazine;
import windy.infrastructure.reposistories.MagazineRepository;

@Controller
public class MagazineController {

	private ICommanBus commandBus;
    private MagazineRepository magazineRepository;
	
	public MagazineController(CommandBus commandBus, MagazineRepository magazineRepository) {
		this.commandBus = commandBus;
		this.magazineRepository = magazineRepository;
	}
	
	@RequestMapping(value="magazine", method=RequestMethod.GET)
	public List<Magazine> getAll() {
		return magazineRepository.getAll();
	}
	
	@RequestMapping(value="magazine/{id}", method=RequestMethod.GET)
	public Magazine getMagazineById(@RequestBody UUID _id) {
		return magazineRepository.getById(_id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void create(@RequestBody Magazine magazine) {
		CreateMagazineCommand createMagazineCommand = new CreateMagazineCommand(magazine.getUid(), magazine.getTitle(), magazine.getAuthor());
		commandBus.send(createMagazineCommand);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void updateGeneralInfo(@RequestBody Magazine magazine) {
		UpdateMagazineGeneralInfoCommand updateMagazineCommand = new UpdateMagazineGeneralInfoCommand(magazine.getUid(), magazine.getTitle(), magazine.getAuthor());
		commandBus.send(updateMagazineCommand);
	}
	
	@RequestMapping(value="magazine/{id}", method=RequestMethod.DELETE)
	public void delete(@RequestBody UUID _id) {
		DeleteMagazineCommand deleteMagazineCommand = new DeleteMagazineCommand(_id);
		commandBus.send(deleteMagazineCommand);
	}
}
