package online.vonarx.actor;

import lombok.Getter;

public enum Origin {
	MAIN_GAME("Main Game"),
	LETO_S_LAB_UPDATE("LL Update"),
	SWAMPS_OF_CORSUS_UPDATE("SoC Update"),
	UNKNOWN("Unknown");

	@Getter private final String displayName;

	Origin(final String displayName) {
		this.displayName = displayName;
	}
}
