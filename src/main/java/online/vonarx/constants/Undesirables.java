package online.vonarx.constants;

import java.util.Set;

import static online.vonarx.constants.KnownActorIdentifiers.CRYPTOLITH_LABYRINTH_FULL;
import static online.vonarx.constants.KnownActorIdentifiers.CULT_OF_THE_ROOT_NEXUS_FULL;

public abstract class Undesirables {

	public static final Set<String> redundantActorsPartialIdentifiers = Set.of(
		CULT_OF_THE_ROOT_NEXUS_FULL, CRYPTOLITH_LABYRINTH_FULL,
		"/Campaign_Main/", "/Quest_AdventureMode/",
		"/Templates/");
}
