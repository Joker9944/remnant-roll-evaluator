package online.vonarx.dictionary;

import online.vonarx.actor.Mode;
import online.vonarx.actor.Type;
import online.vonarx.dictionary.implementation.MapDictionary;

import java.util.Map;
import java.util.Set;

import static online.vonarx.actor.KnownActorIdentifiers.CULT_OF_THE_ROOT_NEXUS_FULL;

public abstract class Undesirables {

	public static final Set<Type> redundantActorTypes = Set.of();
	public static final Set<String> redundantActors = Set.of(CULT_OF_THE_ROOT_NEXUS_FULL);
	public static final Dictionary<Mode, Set<String>> redundantActorsByMode = new MapDictionary<>(Map.of(
		Mode.STORY, Set.of(
			"/Templates/",
			"/Campaign_Main/"),
		Mode.ADVENTURE, Set.of(
			"/Templates/",
			"/Quest_AdventureMode/")
	));
}
