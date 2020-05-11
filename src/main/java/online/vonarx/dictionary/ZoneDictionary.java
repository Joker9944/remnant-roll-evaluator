package online.vonarx.dictionary;

import online.vonarx.actor.Zone;
import online.vonarx.dictionary.implementation.PartialKeyMapDictionary;

import java.util.Map;

import static online.vonarx.actor.Zone.*;

public abstract class ZoneDictionary {

	public static final Dictionary<String, Zone> dictionary = new PartialKeyMapDictionary<>(Map.of(
		"City_Overworld_Zone1", FAIRVIEW,
		"City_Overworld_Zone2", WESTCOURT,
		"Wasteland_Overworld_Zone1", THE_EASTERN_WIND,
		"Wasteland_Overworld_Zone2", THE_SCOURING_WASTE,
		"Swamp_Overworld_Zone1", THE_FETID_GLADE,
		"Swamp_Overworld_Zone2", THE_MIST_FEN,
		"Jungle_Overworld_Zone1", THE_VERDANT_STRAND,
		"Jungle_Overworld_Zone2", THE_SCALDING_GLADE
	));
}
