package online.vonarx.save;

import lombok.RequiredArgsConstructor;
import online.vonarx.actor.*;
import online.vonarx.dictionary.Undesirables;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
public class SavePrinter {

	public static final int QUEST_IDENTIFIER_INDEX = 4;

	private final boolean showEngineNames;
	private final boolean showEngineActors;

	public String printSave(final Save save) {
		final var actors = new ArrayList<>(save.actors());
		purgeDuplicateQuestEntries(actors);
		if (!showEngineActors)
			purgeRedundantActors(actors);
		final var groupedActors = groupActors(actors);
		return print(groupedActors);
	}

	private static void purgeDuplicateQuestEntries(final List<Actor> actorNames) {
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

	private static void purgeRedundantActors(final List<Actor> actors) {
		final var undesirables = actors.stream()
			.filter(actor -> Undesirables.redundantActorTypes.contains(actor.type()) ||
				Undesirables.redundantActorsByMode.lookup(actor.mode()).orElseThrow(IllegalStateException::new).stream()
					.anyMatch(undesirableActorName -> actor.name().contains(undesirableActorName)))
			.collect(toList());
		actors.removeAll(undesirables);
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

	private String print(final Map<Mode, Map<Biome, Map<Zone, Map<Type, List<Actor>>>>> groupedActors) {
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
