package online.vonarx.actor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.function.Predicate;

import static java.util.Arrays.stream;

@Accessors
@RequiredArgsConstructor
public enum Biome {
	BASE("Ward 13"),
	CITY("Earth"),
	LABYRINTH("The Labyrinth"),
	WASTELAND("Rhom"),
	SWAMP("Corsus"),
	JUNGLE("Yaesha"),
	ATOLL("Ward 17"),
	UNKNOWN("Unknown");

	@Getter private final String displayName;

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
