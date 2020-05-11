package online.vonarx.dictionary;

import online.vonarx.actor.Biome;
import online.vonarx.dictionary.implementation.RegExKeyMapDictionary;

import java.util.Map;

import static online.vonarx.actor.Biome.*;

public abstract class BiomeDictionary {

	public static final Dictionary<String, Biome> dictionary = new RegExKeyMapDictionary<>(Map.of(
		"^/Game/World_Base/.*$", WARD_13,
		"^/Game/World_City/.*$", EARTH,
		"^/Game/World_Labyrinth/.*$", THE_LABYRINTH,
		"^/Game/World_Wasteland/.*$", RHOM,
		"^/Game/World_Swamp/.*$", CORSUS,
		"^/Game/World_Jungle/.*$", YAESHA,
		"^/Game/World_Atoll/.*$", WARD_17
	));
}
