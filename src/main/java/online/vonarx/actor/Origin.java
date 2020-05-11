package online.vonarx.actor;

import lombok.Getter;
import online.vonarx.dictionary.OriginDictionary;

public enum Origin {
	MAIN_GAME("Main Game"),
	LETO_S_LAB_UPDATE("LL Update"),
	SWAMPS_OF_CORSUS_UPDATE("SoC Update"),
	UNKNOWN("Unknown");

	@Getter private final String displayName;

	static Origin matchOrigin(final String identifier) {
		return OriginDictionary.dictionary.lookup(identifier)
			.orElse(UNKNOWN);
	}

	Origin(final String displayName) {
		this.displayName = displayName;
	}
}
