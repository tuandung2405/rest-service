package windy.infrastructure.contracts.commands.magazine;

import java.util.UUID;

public class UpdateMagazineGeneralInfoCommand extends MagazineCommand {

	private String title;
	private String author;

	public UpdateMagazineGeneralInfoCommand(UUID uuid, String title, String author) {
		super(uuid);
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
}
