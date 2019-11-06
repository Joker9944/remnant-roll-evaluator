package online.vonarx.dictionary;

import online.vonarx.actor.Mode;
import online.vonarx.actor.Type;

import java.util.Map;
import java.util.Set;

public abstract class Undesirables {

	public static final Set<Type> redundantActorTypes = Set.of();

	public static final Map<Mode, Set<String>> redundantActorsByMode = Map.of(
		Mode.STORY, Set.of(
			"/Templates/",
			"/Campaign_Main/",
			"Quest_SmallD_BlinkThief"),
		Mode.ADVENTURE, Set.of(
			"/Templates/",
			"/Quest_AdventureMode/",
			"Quest_SmallD_BlinkThief")
	);
}
