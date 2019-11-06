package online.vonarx.actor;

import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.function.Predicate;

import static java.util.Arrays.stream;

public enum Biome {
	BASE("Ward 13"),
	CITY("Earth"),
	LABYRINTH("The Labyrinth"),
	WASTELAND("Rhom"),
	SWAMP("Corsus"),
	JUNGLE("Yaesha"),
	ATOLL("Ward 17"),
	UNKNOWN("Unknown");

	@Getter
	@Accessors
	private final String displayName;

	Biome (final String displayName) {
		this.displayName = displayName;
	}

	public static Biome matchBiome(final String name) {
		return stream(values())
			.filter(nameMatchesBiome(name))
			.findAny()
			.orElse(UNKNOWN);
	}

	private static Predicate<Biome> nameMatchesBiome(final String name) {
		return biome -> name.matches("(?i)^/Game/World_" + biome + "/.*$");
	}
}
