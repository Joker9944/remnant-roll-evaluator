package online.vonarx.formatter;

import lombok.RequiredArgsConstructor;
import online.vonarx.models.Actor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static online.vonarx.constants.KnownActorIdentifiers.CRYPTOLITH_LABYRINTH;
import static online.vonarx.constants.KnownActorIdentifiers.CULT_OF_THE_ROOT_NEXUS;

@RequiredArgsConstructor
public abstract class Formatter {

	private static final int QUEST_IDENTIFIER_INDEX = 4;

	public static final Set<String> REDUNDANT_ACTORS = Set.of(
		CULT_OF_THE_ROOT_NEXUS, CRYPTOLITH_LABYRINTH,
		"/Campaign_Main/", "/Quest_AdventureMode/",
		"/Templates/");

	public abstract String format(final List<Actor> actors);

	protected List<Actor> purgeDuplicateQuestEntries(final List<Actor> actors) {
		final List<String> knownQuestsIdentifiers = new ArrayList<>();
		return actors.stream()
			.filter(actor -> {
				if (!actor.identifier().contains("/Quests/"))
					return true;
				final var questIdentifier = actor.identifier().split("/")[QUEST_IDENTIFIER_INDEX];
				if (knownQuestsIdentifiers.contains(questIdentifier))
					return false;
				else {
					knownQuestsIdentifiers.add(questIdentifier);
					return true;
				}
			}).collect(toList());
	}

	protected List<Actor> purgeRedundantActors(final List<Actor> actors) {
		return actors.stream()
			.filter(actor -> REDUNDANT_ACTORS.stream().noneMatch(redundantActor -> actor.identifier().contains(redundantActor)))
			.collect(toList());
	}
}
