package online.vonarx.formatter;

import online.vonarx.constants.Biome;
import online.vonarx.constants.Type;
import online.vonarx.constants.Zone;
import online.vonarx.models.Actor;
import online.vonarx.models.AppParameters;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public abstract class ListFormatter extends Formatter {

	private final boolean showIdentifiers;
	private final boolean showRedundantActors;

	public ListFormatter(final AppParameters parameters) {
		this.showIdentifiers = parameters.showIdentifiers();
		this.showRedundantActors = parameters.showRedundantActors();
	}

	@Override
	public final String format(List<Actor> actors) {
		actors = purgeDuplicateQuestEntries(actors);
		if (!showRedundantActors)
			actors = purgeRedundantActors(actors);
		return formatList(groupActors(actors));
	}

	protected abstract String formatList(final Map<Biome, Map<Zone, Map<Type, List<Actor>>>> groupedActors);

	private Map<Biome, Map<Zone, Map<Type, List<Actor>>>> groupActors(final List<Actor> actors) {
		return actors.stream()
			.sorted(comparing(actor -> actor.name().orElse(actor.identifier())))
			.sorted(comparing(Actor::type))
			.sorted(comparing(Actor::zone))
			.sorted(comparing(Actor::biome))
			.collect(
				groupingBy(Actor::biome, LinkedHashMap::new,
					groupingBy(Actor::zone, LinkedHashMap::new,
						groupingBy(Actor::type, LinkedHashMap::new,
							toList()))));
	}

	protected String printActor(final Actor actor) {
		if (actor.name().isEmpty()) {
			return actor.identifier();
		} else if (showIdentifiers) {
			return actor.name().get() + " (" + actor.identifier() + ")";
		} else {
			return actor.name().get();
		}
	}
}
