package online.vonarx.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Biome {
	WARD_13("Ward 13"),
	EARTH("Earth"),
	THE_LABYRINTH("The Labyrinth"),
	RHOM("Rhom"),
	CORSUS("Corsus"),
	YAESHA("Yaesha"),
	WARD_17("Ward 17"),
	UNKNOWN("Unknown");

	@Getter private final String displayName;
}
