package online.vonarx.dictionary;

import online.vonarx.actor.RelatedActor;
import online.vonarx.actor.Type;
import online.vonarx.dictionary.implementation.PartialKeyMapDictionary;

import java.util.List;
import java.util.Map;

public abstract class RelatedActorsDictionary {

	public static final Dictionary<String, List<RelatedActor>> dictionary = new PartialKeyMapDictionary<>(Map.ofEntries(
		// Earth relations
		Map.entry("Quest_MiniBoss_Splitter",
			List.of(
				new RelatedActor("Leto's Lab (Dungeon)", Type.QUEST)
			)
		),
		Map.entry("Quest_OverworldPOI_OldManAndConstruct",
			List.of(
				new RelatedActor("Ancient Construct", Type.BOSS)
			)
		),
		Map.entry("Quest_OverWorldPOI_StuckMerchant",
			List.of(
				new RelatedActor("Root Horror", Type.BOSS)
			)
		),
		Map.entry("Quest_SmallD_BlinkThief",
			List.of(
				new RelatedActor("Moved from QUEST", "Blink Thief", Type.BOSS)
			)
		)
	));
}
