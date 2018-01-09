package windy.infrastructure.contracts.commands.book;

import java.util.UUID;

public class UpdateBookGeneralInfoCommand extends BookCommand {

	private String title;
	private String author;

	public UpdateBookGeneralInfoCommand(UUID uuid, String title, String author) {
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
