package online.vonarx.components.dictionaries.world;

import online.vonarx.constants.world.Biome;
import online.vonarx.dictionary.DictionaryWrapper;
import online.vonarx.dictionary.implementation.ChainDictionary;
import online.vonarx.dictionary.implementation.PartialKeyMapDictionary;
import online.vonarx.dictionary.implementation.RegExKeyMapDictionary;

import javax.inject.Inject;

import static online.vonarx.constants.world.Biome.*;

public class BiomeDictionary extends DictionaryWrapper<String, Biome> {

	@Inject
	public BiomeDictionary() {
		super(ChainDictionary.<String, Biome>builder()
			.addDictionary(RegExKeyMapDictionary.<Biome>builder()
				.put("^/Game/World_Base/.*$", WARD_13)
				.put("^/Game/World_City/.*$", EARTH)
				.put("^/Game/World_Labyrinth/.*$", THE_LABYRINTH)
				.put("^/Game/World_Wasteland/.*$", RHOM)
				.put("^/Game/World_Swamp/.*$", CORSUS)
				.put("^/Game/World_Jungle/.*$", YAESHA)
				.put("^/Game/World_Atoll/.*$", WARD_17)
				.build())
			.addDictionary(PartialKeyMapDictionary.<Biome>builder()
				.put("Quest_Boss_UndyingKing", RHOM)
				.build())
			.build());
	}
}
