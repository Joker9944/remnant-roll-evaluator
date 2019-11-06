package online.vonarx.actor;

import lombok.Getter;
import lombok.experimental.Accessors;

public enum Mode {
	STORY("Story"),
	ADVENTURE("Adventure");

	@Getter
	@Accessors
	private final String displayName;

	Mode(final String displayName) {
		this.displayName = displayName;
	}
}
