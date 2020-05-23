package online.vonarx.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import online.vonarx.components.dictionaries.ZoneDictionary;

@RequiredArgsConstructor
public enum Zone {
	FAIRVIEW("Fairview"),
	WESTCOURT("Westcourt"),
	THE_EASTERN_WIND("The Eastern Wind"),
	THE_SCOURING_WASTE("The Scouring Waste"),
	THE_FETID_GLADE("The Fetid Glade"),
	THE_MIST_FEN("The Mist Fen"),
	THE_VERDANT_STRAND("The Verdant Strand"),
	THE_SCALDING_GLADE("The Scalding Glade"),
	NONE("None");

	@Getter private final String displayName;
}
