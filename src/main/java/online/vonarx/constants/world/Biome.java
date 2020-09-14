package online.vonarx.constants.world;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Biome {
	WARD_13("Ward 13"),
	CITY_EARTH("City Earth"),
	THE_LABYRINTH("The Labyrinth"),
	RHOM("Rhom"),
	CORSUS("Corsus"),
	YAESHA("Yaesha"),
	WARD_17("Ward 17"),
	UNKNOWN("Unknown"),
	// Subject 2923 update
	RURAL_EARTH("Rural Earth"),
	REISUM("Reisum");

	@Getter private final String displayName;
}
