package online.vonarx.dictionary;

import online.vonarx.actor.RelatedActor;
import online.vonarx.actor.Type;
import online.vonarx.dictionary.implementation.MapDictionary;

import java.util.List;
import java.util.Map;

public abstract class RelatedActorsDictionary {

	public static final Dictionary<String, List<RelatedActor>> dictionary = new MapDictionary<>(
		Map.ofEntries(
			Map.entry("/Game/World_City/Quests/Quest_MiniBoss_Splitter/Quest_MiniBoss_Splitter.Quest_MiniBoss_Splitter", List.of(
				new RelatedActor("Based on Riphide", "Leto's Lab (Dungeon)", Type.QUEST)
			)),
			Map.entry("/Game/World_Wasteland/Quests/Quest_OverworldPOI_OldManAndConstruct/Quest_OverworldPOI_OldManAndConstruct.Quest_OverworldPOI_OldManAndConstruct", List.of(
				new RelatedActor("Based on Wud", "Ancient Construct", Type.BOSS)
			)),
			Map.entry("/Game/World_Jungle/Quests/Quest_OverWorldPOI_StuckMerchant/Quest_OverworldPOI_StuckMerchant.Quest_OverworldPOI_StuckMerchant", List.of(
				new RelatedActor("Based on Stuck Merchant", "Root Horror", Type.BOSS)
			)),
			Map.entry("/Game/World_Jungle/Quests/Quest_SmallD_BlinkThief/Quest_SmallD_BlinkThief.Quest_SmallD_BlinkThief", List.of(
				new RelatedActor("Moved QUEST Blink Thief to BOSS", "Blink Thief", Type.BOSS)
			))
		));
}
