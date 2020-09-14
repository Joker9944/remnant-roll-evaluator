package online.vonarx.constants.world;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static online.vonarx.constants.world.Biome.*;

@RequiredArgsConstructor
public enum Zone {
	FAIRVIEW(EARTH, "Fairview"),
	WESTCOURT(EARTH, "Westcourt"),
	THE_EASTERN_WIND(RHOM, "The Eastern Wind"),
	THE_SCOURING_WASTE(RHOM, "The Scouring Waste"),
	THE_VERDANT_STRAND(CORSUS, "The Verdant Strand"),
	THE_SCALDING_GLADE(CORSUS, "The Scalding Glade"),
	THE_FETID_GLADE(YAESHA, "The Fetid Glade"),
	THE_MIST_FEN(YAESHA, "The Mist Fen"),
	NONE(UNKNOWN, "None");

	@Getter private final Biome biome;
	@Getter private final String displayName;
}
