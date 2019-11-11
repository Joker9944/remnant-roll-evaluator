package online.vonarx.dictionary;

import online.vonarx.actor.RelatedActor;
import online.vonarx.actor.Type;
import online.vonarx.dictionary.implementation.MapDictionary;

import java.util.List;
import java.util.Map;

import static online.vonarx.actor.KnownActorIdentifiers.*;

public abstract class RelatedActorsDictionary {

	public static final Dictionary<String, List<RelatedActor>> dictionary = new MapDictionary<>(Map.ofEntries(
		Map.entry(RIPHIDE_FULL, List.of(
			new RelatedActor("Based on Riphide", Type.DUNGEON, "Leto's Lab", "Research Station Alpha")
		)),
		Map.entry(WUD_FULL, List.of(
			new RelatedActor("Based on Wud", Type.BOSS, "Ancient Construct")
		)),
		Map.entry(STUCK_MERCHANT_FULL, List.of(
			new RelatedActor("Based on Stuck Merchant", Type.BOSS, "Root Horror")
		))
	));
}
