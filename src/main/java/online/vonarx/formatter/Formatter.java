package online.vonarx.formatter;

import lombok.RequiredArgsConstructor;
import online.vonarx.constants.Undesirables;
import online.vonarx.models.Actor;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
public abstract class Formatter {

	private static final int QUEST_IDENTIFIER_INDEX = 4;

	public abstract String format(final List<Actor> actors);

	protected static void purgeDuplicateQuestEntries(final List<Actor> actors) {
		final var duplicateQuestEntries = actors.stream()
			.filter(actor -> actor.identifier().contains("/Quests/"))
			.collect(groupingBy(actor -> actor.identifier().split("/")[QUEST_IDENTIFIER_INDEX]))
			.values().stream()
			.filter(groupedActors -> groupedActors.size() > 1)
			.map(groupedActors -> groupedActors.subList(1, groupedActors.size()))
			.flatMap(Collection::stream)
			.collect(toList());
		actors.removeAll(duplicateQuestEntries);
	}

	protected static void purgeRedundantActors(final List<Actor> actors) {
		final var undesirables = actors.stream()
			.filter(actor -> Undesirables.redundantActorsPartialIdentifiers.contains(actor.identifier()))
			.collect(toList());
		actors.removeAll(undesirables);
	}
}
