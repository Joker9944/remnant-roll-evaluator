package online.vonarx.actor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Arrays;

@Accessors
@RequiredArgsConstructor
public enum Zone {
	FAIRVIEW("Fairview", "City_Overworld_Zone1"),
	WESTCOURT("Westcourt", "City_Overworld_Zone2"),
	THE_EASTERN_WIND("The Eastern Wind", "Wasteland_Overworld_Zone1"),
	THE_SCOURING_WASTE("The Scouring Waste", "Wasteland_Overworld_Zone2"),
	THE_FETID_GLADE("The Fetid Glade", "Swamp_Overworld_Zone1"),
	THE_MIST_FEN("The Mist Fen", "Swamp_Overworld_Zone2"),
	THE_VERDANT_STRAND("The Verdant Strand", "Jungle_Overworld_Zone1"),
	THE_SCALDING_GLADE("The Scalding Glade", "Jungle_Overworld_Zone2"),
	NONE("None", null);

	@Getter private final String displayName;
	private final String keyword;

	public static Zone matchZone(final String name) {
		return Arrays.stream(values())
			.filter(zone -> zone.keyword != null)
			.filter(zone -> name.contains(zone.keyword))
			.findAny()
			.orElse(NONE);
	}
}
