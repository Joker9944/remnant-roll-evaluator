package online.vonarx.components.dictionaries.world;

import online.vonarx.constants.Type;
import online.vonarx.dictionary.DictionaryWrapper;
import online.vonarx.dictionary.implementation.ChainDictionary;
import online.vonarx.dictionary.implementation.RegExKeyMapDictionary;

import javax.inject.Inject;

import static online.vonarx.constants.Type.*;

public class TypeDictionary extends DictionaryWrapper<String, Type> {

	@Inject
	public TypeDictionary() {
		super(ChainDictionary.<String, Type>builder()
			.addDictionary(RegExKeyMapDictionary.<Type>builder()
				.put("^/Game/World_.+/Quests/Quest_Boss_.*$", WORLD_BOSS)
				.put("^/Game/World_.+/Quests/Quest_Mini.oss_.*$", BOSS)
				.put("^/Game/World_.+/Quests/Quest_Over.orldPOI_.*$", POINT_OF_INTEREST)
				.put("^/Game/World_.+/Quests/Quest_Siege_.*$", SIEGE)
				.put("^/Game/World_.+/Quests/Quest_SmallD_.*$", DUNGEON)
				.put("^/Game/World_.+/Quests/Quest_Event_.*$", PICKUP)
				.put("^/Game/Campaign_Main/.*$", MAIN_QUEST)
				.put("^/Game/.+/Templates/.*$", TEMPLATE)
				.build())
			.addDictionary(RegExKeyMapDictionary.<Type>builder()
				.put("^/Game/World_.+/Quests.*$", QUEST)
				.build())
			.build()
		);
	}
}
