package online.vonarx.dictionary;

import online.vonarx.actor.Mode;
import online.vonarx.actor.Type;
import online.vonarx.dictionary.implementation.MapDictionary;

import java.util.Map;
import java.util.Set;

public abstract class Undesirables {

	public static final Set<Type> redundantActorTypes = Set.of();
	public static final Dictionary<Mode, Set<String>> redundantActorsByMode = new MapDictionary<>(Map.of(
		Mode.STORY, Set.of(
			"/Templates/",
			"/Campaign_Main/"),
		Mode.ADVENTURE, Set.of(
			"/Templates/",
			"/Quest_AdventureMode/")
	));
}
