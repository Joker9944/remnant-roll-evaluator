package online.vonarx.actor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import online.vonarx.dictionary.BiomeDictionary;

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

	static Biome matchBiome(final String identifier) {
		return BiomeDictionary.dictionary.lookup(identifier)
			.orElse(UNKNOWN);
	}
}
