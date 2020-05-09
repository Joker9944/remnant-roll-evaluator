package online.vonarx.actor;

import lombok.Getter;

public enum Origin {
	MAIN_GAME("Main Game"),
	LETOS_LAB_UPDATE("Leto's Lab Update"),
	SWAMPS_OF_CORSUS_UPDATE("Swamps of Corsus Update"),
	UNKNOWN("Unknown");

	@Getter private final String displayName;

	Origin(final String displayName) {
		this.displayName = displayName;
	}
}
