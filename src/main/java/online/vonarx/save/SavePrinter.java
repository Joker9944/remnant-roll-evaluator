package online.vonarx.save;

import lombok.RequiredArgsConstructor;
import online.vonarx.actor.*;
import online.vonarx.dictionary.Undesirables;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
public class SavePrinter {

	private final boolean verbose;
	private final boolean showEngineNames;
	private final boolean showRedundantActors;

	public String printSave(final Save save) {
		final var actors = new ArrayList<>(save.actors());
		if (!verbose)
			purgeChildActors(actors);
		if (!showRedundantActors)
			purgeRedundantActors(actors);
		final var groupedActors = groupActors(actors);
		return print(groupedActors);
	}

	private static void purgeChildActors(final List<Actor> actors) {
		final var redundantActors = actors.stream()
			.filter(actor -> Undesirables.childActors.stream()
				.anyMatch(redundantActorName -> actor.name().contains(redundantActorName)))
			.collect(toList());
		actors.removeAll(redundantActors);
	}

	private static void purgeRedundantActors(final List<Actor> actors) {
		final var undesirables = actors.stream()
			.filter(actor -> Undesirables.redundantActorTypes.contains(actor.type()) ||
				Undesirables.redundantActorsByMode.get(actor.mode()).stream()
					.anyMatch(undesirableActorName -> actor.name().contains(undesirableActorName)))
			.collect(toList());
		actors.removeAll(undesirables);
	}

	private Map<Mode, Map<Biome, Map<Zone, Map<Type, List<Actor>>>>> groupActors(final List<Actor> actors) {
		return actors.stream()
			.collect(
				groupingBy(Actor::mode, LinkedHashMap::new,
					groupingBy(Actor::biome, LinkedHashMap::new,
						groupingBy(Actor::zone, LinkedHashMap::new,
							groupingBy(Actor::type, LinkedHashMap::new,
								toList())))));
	}

	private String print(final Map<Mode, Map<Biome, Map<Zone, Map<Type, List<Actor>>>>> groupedActors) {
		final var sb = new StringBuilder();
		groupedActors.forEach((mode, biomes) -> {
			sb.append(mode.displayName()).append("\n\n");
			biomes.forEach((biome, zones) -> {
				sb.append(biome.displayName()).append("\n");
				zones.forEach((zone, types) -> {
					sb.append(" ").append(zone.displayName()).append("\n");
					types.forEach((type, actors) -> {
						sb.append("  ").append(type.displayName()).append("\n");
						actors.forEach(actor -> sb.append("   - ").append(printActor(actor)).append("\n"));
					});
					sb.append("\n");
				});
			});
		});
		return sb.toString();
	}

	private String printActor(final Actor actor) {
		if (actor.displayName().isEmpty()) {
			return actor.name();
		} else if (showEngineNames) {
			return actor.displayName().get() + " (" + actor.name() + ")";
		} else {
			return actor.displayName().get();
		}
	}

}
