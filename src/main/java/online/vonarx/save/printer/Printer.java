package online.vonarx.save.printer;

import online.vonarx.actor.Actor;
import online.vonarx.dictionary.RelatedActorsDictionary;
import online.vonarx.dictionary.Undesirables;
import online.vonarx.save.Save;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public abstract class Printer<T> {

	private static final int QUEST_IDENTIFIER_INDEX = 4;

	public abstract T print(final Save save);

	protected static void addRelatedActors(final List<Actor> actors) {
		final var relatedActors = actors.stream()
			.map(actor -> RelatedActorsDictionary.dictionary.lookup(actor.name())
				.orElse(Collections.emptyList()).stream()
				.map(relatedActor -> relatedActor.adapt(actor))
				.collect(toList()))
			.flatMap(Collection::stream)
			.collect(toList());
		actors.addAll(relatedActors);
	}

	protected static void purgeDuplicateQuestEntries(final List<Actor> actorNames) {
		final var duplicateQuestEntries = actorNames.stream()
			.filter(actor -> actor.name().contains("/Quests/"))
			.collect(groupingBy(actor -> actor.mode() + "|" + actor.name().split("/")[QUEST_IDENTIFIER_INDEX]))
			.values().stream()
			.filter(actors -> actors.size() > 1)
			.map(actors -> actors.subList(1, actors.size()))
			.flatMap(Collection::stream)
			.collect(toList());
		actorNames.removeAll(duplicateQuestEntries);
	}

	protected static void purgeRedundantActors(final List<Actor> actors) {
		final var undesirables = actors.stream()
			.filter(actor -> Undesirables.redundantActorTypes.contains(actor.type()) ||
				Undesirables.redundantActorsByMode.lookup(actor.mode()).orElseThrow(IllegalStateException::new).stream()
					.anyMatch(undesirableActorName -> actor.name().contains(undesirableActorName)))
			.collect(toList());
		actors.removeAll(undesirables);
	}
}