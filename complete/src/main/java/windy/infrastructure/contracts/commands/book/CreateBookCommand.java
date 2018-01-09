package windy.infrastructure.contracts.commands.book;

import java.util.UUID;

public class CreateBookCommand extends BookCommand {

	private String title;
	private String author;

	public CreateBookCommand(UUID uid, String title, String author) {
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
