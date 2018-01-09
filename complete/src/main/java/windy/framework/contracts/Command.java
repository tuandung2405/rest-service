package windy.framework.contracts;

import java.util.UUID;

public abstract class Command {
	
	protected UUID uid;

	public Command(UUID uid) {
		super();
		this.uid = uid;
	}
	
	public UUID getUid() {
		return uid;
	}
	
	public void execute() {
		
	}
}
