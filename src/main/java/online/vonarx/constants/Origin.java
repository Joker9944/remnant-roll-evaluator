package online.vonarx.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Origin {
	MAIN_GAME("Main Game"),
	LETO_S_LAB_UPDATE("LL Update"),
	SWAMPS_OF_CORSUS_UPDATE("SoC Update"),
	UNKNOWN("Unknown");

	@Getter private final String displayName;
}
