package windy.infrastructure.contracts.commands.magazine;

import java.util.UUID;

public class CreateMagazineCommand extends MagazineCommand{
	
	private String title;
	private String author;

	public CreateMagazineCommand(UUID uid, String title, String author) {
		super(uid);
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
