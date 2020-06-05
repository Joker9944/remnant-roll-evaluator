package online.vonarx.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Origin {
	MAIN_GAME("Main Game"),
	ADVENTURE_MODE_UPDATE("AM Update"),
	LETO_S_LAB_UPDATE("LL Update"),
	HARDCORE_UPDATE("HC Update"),
	SWAMPS_OF_CORSUS_UPDATE("SoC Update"),
	UNKNOWN("Unknown");

	@Getter private final String displayName;
}
