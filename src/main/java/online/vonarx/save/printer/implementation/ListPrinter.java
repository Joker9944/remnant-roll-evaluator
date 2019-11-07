package online.vonarx.save.printer.implementation;

import lombok.RequiredArgsConstructor;
import online.vonarx.actor.*;
import online.vonarx.save.Save;
import online.vonarx.save.printer.Printer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
public class ListPrinter extends Printer<String> {

	private final boolean showEngineNames;
	private final boolean showEngineActors;

	@Override
	public String print(final Save save) {
		final var actors = new ArrayList<>(save.actors());
		addRelatedActors(actors);
		purgeDuplicateQuestEntries(actors);
		if (!showEngineActors)
			purgeRedundantActors(actors);
		final var groupedActors = groupActors(actors);
		return printGroupedActors(groupedActors);
	}

	private Map<Mode, Map<Biome, Map<Zone, Map<Type, List<Actor>>>>> groupActors(final List<Actor> actors) {
		return actors.stream()
			.sorted(comparing(actor -> actor.displayName().orElse(actor.name())))
			.sorted(comparingInt(actor -> actor.type().order()))
			.sorted(comparing(Actor::zone))
			.sorted(comparing(Actor::biome))
			.sorted(comparing(Actor::mode))
			.collect(
				groupingBy(Actor::mode, LinkedHashMap::new,
					groupingBy(Actor::biome, LinkedHashMap::new,
						groupingBy(Actor::zone, LinkedHashMap::new,
							groupingBy(Actor::type, LinkedHashMap::new,
								toList())))));
	}

	private String printGroupedActors(final Map<Mode, Map<Biome, Map<Zone, Map<Type, List<Actor>>>>> groupedActors) {
		final var sb = new StringBuilder();
		groupedActors.forEach((mode, biomes) -> {
			if (mode.equals(Mode.STORY)) {
				sb.append(printStoryMode(biomes));
			} else {
				sb.append(printAdventureMode(biomes));
			}
			sb.append("\n");
		});
		return sb.toString();
	}

	private String printStoryMode(final Map<Biome, Map<Zone, Map<Type, List<Actor>>>> biomes) {
		final var sb = new StringBuilder();
		sb.append(Mode.STORY.displayName()).append("\n\n");
		biomes.forEach((biome, zones) -> {
			sb.append(biome.displayName()).append("\n");
			zones.forEach((zone, types) -> {
				sb.append("\t").append(zone.displayName()).append("\n");
				types.forEach((type, actors) -> {
					sb.append("\t\t").append(type.displayName()).append("\n");
					actors.forEach((actor) -> sb.append("\t\t - ").append(this.printActor(actor)).append("\n"));
				});
				sb.append("\n");
			});
		});
		return sb.toString();
	}

	private String printAdventureMode(final Map<Biome, Map<Zone, Map<Type, List<Actor>>>> biomes) {
		final var sb = new StringBuilder();
		biomes.forEach((biome, zones) -> {
			sb.append(Mode.ADVENTURE.displayName()).append(" (").append(biome.displayName()).append(")").append("\n");
			zones.values().forEach(types -> types.forEach((type, actors) -> {
				sb.append("\t").append(type.displayName()).append("\n");
				actors.forEach((actor) -> sb.append("\t\t").append(" - ").append(this.printActor(actor)).append("\n"));
			}));
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
