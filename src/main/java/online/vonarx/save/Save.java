package online.vonarx.save;

import lombok.Data;
import lombok.experimental.Accessors;
import online.vonarx.actor.Actor;
import online.vonarx.actor.Mode;
import online.vonarx.actor.Zone;
import online.vonarx.dictionary.RelatedActorsDictionary;

import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

@Data
@Accessors
public class Save {

	private static final Pattern actorNamePattern = Pattern.compile("/Game/[a-zA-Z0-9/._]+");

	private final List<Actor> actors;

	public Save(final String saveBinary) {
		final var actorNamesDirty = extractActorNames(saveBinary);
		final var actorNamesByMode = filterSaveByModes(actorNamesDirty);
		final var actors = mapToActorObject(actorNamesByMode);
		addRelatedActors(actors);
		this.actors = Collections.unmodifiableList(actors);
	}

	private static List<String> extractActorNames(final String save) {
		return actorNamePattern.matcher(save).results()
			.map(MatchResult::group)
			.collect(toList());
	}

	private static Map<Mode, List<String>> filterSaveByModes(final List<String> unfilteredActorNames) {
		return Map.of(
			Mode.STORY, extractStoryMode(unfilteredActorNames),
			Mode.ADVENTURE, extractAdventureMode(unfilteredActorNames)
		);
	}

	private static final String startStoryMode = "/Game/Campaign_Main/Quest_Campaign_City.Quest_Campaign_City";
	private static final String endStoryMode = "/Game/Campaign_Main/Quest_Campaign_Ward13.Quest_Campaign_Ward13";

	private static List<String> extractStoryMode(final List<String> unfilteredActorNames) {
		final var startIndex = unfilteredActorNames.indexOf(startStoryMode);
		final var endIndex = unfilteredActorNames.indexOf(endStoryMode);
		if (startIndex == -1 || endIndex == -1)
			throw new IllegalStateException("Could not find story mode.");
		return new ArrayList<>(unfilteredActorNames.subList(startIndex, endIndex + 1));
	}

	private static final String startAdventureModeRegEx = "^/Game/World_.+/Quests/Quest_AdventureMode/Quest_AdventureMode_[a-zA-Z]+_\\d{2}\\.Quest_AdventureMode_[a-zA-Z]+_\\d{2}$";
	private static final String endAdventureModeRegEx = "^/Game/World_.+/Quests/Quest_AdventureMode/Quest_AdventureMode_.+\\.Quest_AdventureMode_.+_C$";

	private static List<String> extractAdventureMode(final List<String> unfilteredActorNames) {
		final var startIndexName = unfilteredActorNames.stream()
			.filter(name -> name.matches(startAdventureModeRegEx))
			.findFirst();
		final var endIndexName = unfilteredActorNames.stream()
			.filter(name -> name.matches(endAdventureModeRegEx))
			.findFirst();
		if (startIndexName.isEmpty() || endIndexName.isEmpty()) {
			System.out.println("No adventure mode found.");
			return Collections.emptyList();
		}
		final var startIndex = unfilteredActorNames.indexOf(startIndexName.get());
		final var endIndex = unfilteredActorNames.indexOf(endIndexName.get());
		return new ArrayList<>(unfilteredActorNames.subList(startIndex, endIndex));
	}

	private static final String isTemplateRegEx = "^/Game/World_.+/Templates/.*$";

	private static List<Actor> mapToActorObject(final Map<Mode, List<String>> actorNamesByMode) {
		final var mappedActors = new ArrayList<Actor>();
		actorNamesByMode.forEach((mode, actorNames) -> {
			var currentZone = Zone.NONE;
			for (final String actorName : actorNames) {
				if (actorName.matches(isTemplateRegEx))
					currentZone = Zone.matchZone(actorName);
				mappedActors.add(new Actor(actorName, mode, currentZone));
			}
		});
		return mappedActors;
	}

	private static void addRelatedActors(final List<Actor> actors) {
		final var relatedActors = actors.stream()
			.map(actor -> RelatedActorsDictionary.dictionary.lookup(actor.name())
				.orElse(Collections.emptyList()).stream()
				.map(relatedActor -> relatedActor.adapt(actor))
				.collect(toList()))
			.flatMap(Collection::stream)
			.collect(toList());
		actors.addAll(relatedActors);
	}
}
