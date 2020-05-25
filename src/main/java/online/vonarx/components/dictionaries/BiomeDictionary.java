package online.vonarx.components.dictionaries;

import online.vonarx.constants.Biome;
import online.vonarx.dictionary.DictionaryWrapper;
import online.vonarx.dictionary.implementation.RegExKeyMapDictionary;

import javax.inject.Inject;

import static online.vonarx.constants.Biome.*;

public class BiomeDictionary extends DictionaryWrapper<String, Biome> {

	@Inject
	public BiomeDictionary() {
		super(RegExKeyMapDictionary.<Biome>builder()
			.put("^/Game/World_Base/.*$", WARD_13)
			.put("^/Game/World_City/.*$", EARTH)
			.put("^/Game/World_Labyrinth/.*$", THE_LABYRINTH)
			.put("^/Game/World_Wasteland/.*$", RHOM)
			.put("^/Game/World_Swamp/.*$", CORSUS)
			.put("^/Game/World_Jungle/.*$", YAESHA)
			.put("^/Game/World_Atoll/.*$", WARD_17)
			.build()
		);
	}
}
