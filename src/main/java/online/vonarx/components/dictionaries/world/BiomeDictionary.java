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
				.put("^/Game/World_City/.*$", CITY_EARTH)
				.put("^/Game/World_Labyrinth/.*$", THE_LABYRINTH)
				.put("^/Game/World_Wasteland/.*$", RHOM)
				.put("^/Game/World_Swamp/.*$", CORSUS)
				.put("^/Game/World_Jungle/.*$", YAESHA)
				.put("^/Game/World_Atoll/.*$", WARD_17)
				.put("^/Game/World_Rural/.*$", RURAL_EARTH)
				.put("^/Game/World_Snow/.*", REISUM)
				.build())
			.addDictionary(PartialKeyMapDictionary.<Biome>builder()
				.put("Quest_Campaign_City", CITY_EARTH)
				.put("Quest_Church", CITY_EARTH)
				.put("Quest_Campaign_Labyrinth", THE_LABYRINTH)
				.put("Quest_Campaign_Wasteland", RHOM)
				.put("Quest_Boss_UndyingKing", RHOM)
				.put("Quest_Campaign_Swamp", CORSUS)
				.put("Quest_Campaign_Jungle", YAESHA)
				.put("Quest_Pan_Jungle_Ambush", YAESHA)
				.put("Quest_FoundersPrison", YAESHA)
				.put("Quest_Campaign_Ward13", WARD_17)
				.build())
			.build());
	}
}
