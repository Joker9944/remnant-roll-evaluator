package online.vonarx.components.dictionaries;

import online.vonarx.constants.Zone;
import online.vonarx.dictionary.DictionaryWrapper;
import online.vonarx.dictionary.implementation.PartialKeyMapDictionary;

import javax.inject.Inject;

import static online.vonarx.constants.Zone.*;

public class ZoneDictionary extends DictionaryWrapper<String, Zone> {

	@Inject
	public ZoneDictionary() {
		super(PartialKeyMapDictionary.<Zone>builder()
			.put("City_Overworld_Zone1", FAIRVIEW)
			.put("City_Overworld_Zone2", WESTCOURT)
			.put("Wasteland_Overworld_Zone1", THE_EASTERN_WIND)
			.put("Wasteland_Overworld_Zone2", THE_SCOURING_WASTE)
			.put("Swamp_Overworld_Zone1", THE_FETID_GLADE)
			.put("Swamp_Overworld_Zone2", THE_MIST_FEN)
			.put("Jungle_Overworld_Zone1", THE_VERDANT_STRAND)
			.put("Jungle_Overworld_Zone2", THE_SCALDING_GLADE)
			.build()
		);
	}
}
