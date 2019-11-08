package online.vonarx.save.printer;

import lombok.RequiredArgsConstructor;
import online.vonarx.actor.Actor;
import online.vonarx.actor.Mode;
import online.vonarx.dictionary.RelatedActorsDictionary;
import online.vonarx.dictionary.Undesirables;
import online.vonarx.save.Save;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
public abstract class Printer<T> {

	private static final int QUEST_IDENTIFIER_INDEX = 4;

	private final List<Mode> modesToShow;

	public abstract T print(final Save save);

	protected void filterActorsByMode(final List<Actor> actors) {
		final var actorsWithUndesiredMode = actors.stream()
			.filter(actor -> !modesToShow.contains(actor.mode()))
			.collect(toList());
		actors.removeAll(actorsWithUndesiredMode);
	}

	protected static void addRelatedActors(final List<Actor> actors) {
		final var relatedActors = actors.stream()
			.map(actor -> RelatedActorsDictionary.dictionary.lookup(actor.identifier())
				.orElse(Collections.emptyList()).stream()
				.map(relatedActor -> relatedActor.adapt(actor))
				.collect(toList()))
			.flatMap(Collection::stream)
			.collect(toList());
		actors.addAll(relatedActors);
	}

	protected static void purgeDuplicateQuestEntries(final List<Actor> actors) {
		final var duplicateQuestEntries = actors.stream()
			.filter(actor -> actor.identifier().contains("/Quests/"))
			.collect(groupingBy(actor -> actor.mode() + "|" + actor.identifier().split("/")[QUEST_IDENTIFIER_INDEX]))
			.values().stream()
			.filter(groupedActors -> groupedActors.size() > 1)
			.map(groupedActors -> groupedActors.subList(1, groupedActors.size()))
			.flatMap(Collection::stream)
			.collect(toList());
		actors.removeAll(duplicateQuestEntries);
	}

	protected static void purgeRedundantActors(final List<Actor> actors) {
		final var undesirables = actors.stream()
			.filter(actor -> Undesirables.redundantActorTypes.contains(actor.type()) ||
				Undesirables.redundantActorsByMode.lookup(actor.mode()).orElseThrow(IllegalStateException::new).stream()
					.anyMatch(undesirableActorName -> actor.identifier().contains(undesirableActorName)))
			.collect(toList());
		actors.removeAll(undesirables);
	}
}
