package windy.framework.contracts;

import java.util.UUID;

public abstract class IDomain {

	protected UUID uid;

	public IDomain(UUID uid) {
		super();
		this.uid = uid;
	}

	public UUID getUid() {
		return uid;
	}
}
