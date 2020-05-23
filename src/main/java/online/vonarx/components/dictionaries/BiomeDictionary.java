package online.vonarx.components.dictionaries;

import online.vonarx.constants.Biome;
import online.vonarx.dictionary.implementation.RegExKeyMapDictionary;

import javax.inject.Inject;
import java.util.Map;

import static online.vonarx.constants.Biome.*;

public class BiomeDictionary extends RegExKeyMapDictionary<Biome> {

	@Inject
	public BiomeDictionary() {
		super(Map.of(
			"^/Game/World_Base/.*$", WARD_13,
			"^/Game/World_City/.*$", EARTH,
			"^/Game/World_Labyrinth/.*$", THE_LABYRINTH,
			"^/Game/World_Wasteland/.*$", RHOM,
			"^/Game/World_Swamp/.*$", CORSUS,
			"^/Game/World_Jungle/.*$", YAESHA,
			"^/Game/World_Atoll/.*$", WARD_17
		));
	}
}
