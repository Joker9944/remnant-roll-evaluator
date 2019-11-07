package online.vonarx.save;

import lombok.Data;
import lombok.experimental.Accessors;
import online.vonarx.actor.Actor;
import online.vonarx.actor.Mode;
import online.vonarx.actor.Zone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

@Data
@Accessors
public class Save {

	public static final Pattern ACTOR_NAME_PATTERN = Pattern.compile("/Game/[a-zA-Z0-9/._]+");

	public static final String START_STORY_MODE = "/Game/Campaign_Main/Quest_Campaign_City.Quest_Campaign_City";
	public static final String END_STORY_MODE = "/Game/Campaign_Main/Quest_Campaign_Ward13.Quest_Campaign_Ward13";

	public static final String START_ADVENTURE_MODE_REG_EX = "^/Game/World_.+/Quests/Quest_AdventureMode/Quest_AdventureMode_[a-zA-Z]+_\\d{2}\\.Quest_AdventureMode_[a-zA-Z]+_\\d{2}$";
	public static final String END_ADVENTURE_MODE_REG_EX = "^/Game/World_.+/Quests/Quest_AdventureMode/Quest_AdventureMode_.+\\.Quest_AdventureMode_.+_C$";

	public static final String IS_TEMPLATE_REG_EX = "^/Game/World_.+/Templates/.*$";

	private final List<Actor> actors;

	public Save(final String saveBinary) {
		final var actorNamesDirty = extractActorNames(saveBinary);
		final var actorNamesByMode = filterSaveByModes(actorNamesDirty);
		final var actors = mapToActorObject(actorNamesByMode);
		this.actors = Collections.unmodifiableList(actors);
	}

	private static List<String> extractActorNames(final String save) {
		return ACTOR_NAME_PATTERN.matcher(save).results()
			.map(MatchResult::group)
			.collect(toList());
	}

	private static Map<Mode, List<String>> filterSaveByModes(final List<String> unfilteredActorNames) {
		return Map.of(
			Mode.STORY, extractStoryMode(unfilteredActorNames),
			Mode.ADVENTURE, extractAdventureMode(unfilteredActorNames)
		);
	}

	private static List<String> extractStoryMode(final List<String> unfilteredActorNames) {
		final var startIndex = unfilteredActorNames.indexOf(START_STORY_MODE);
		final var endIndex = unfilteredActorNames.indexOf(END_STORY_MODE);
		if (startIndex == -1 || endIndex == -1)
			throw new IllegalStateException("Could not find story mode.");
		return new ArrayList<>(unfilteredActorNames.subList(startIndex, endIndex + 1));
	}

	private static List<String> extractAdventureMode(final List<String> unfilteredActorNames) {
		final var startIndexName = unfilteredActorNames.stream()
			.filter(name -> name.matches(START_ADVENTURE_MODE_REG_EX))
			.findFirst();
		final var endIndexName = unfilteredActorNames.stream()
			.filter(name -> name.matches(END_ADVENTURE_MODE_REG_EX))
			.findFirst();
		if (startIndexName.isEmpty() || endIndexName.isEmpty()) {
			System.out.println("No adventure mode found.");
			return Collections.emptyList();
		}
		final var startIndex = unfilteredActorNames.indexOf(startIndexName.get());
		final var endIndex = unfilteredActorNames.indexOf(endIndexName.get());
		return new ArrayList<>(unfilteredActorNames.subList(startIndex, endIndex));
	}

	private static List<Actor> mapToActorObject(final Map<Mode, List<String>> actorNamesByMode) {
		final var mappedActors = new ArrayList<Actor>();
		actorNamesByMode.forEach((mode, actorNames) -> {
			var currentZone = Zone.NONE;
			for (final String actorName : actorNames) {
				if (actorName.matches(IS_TEMPLATE_REG_EX))
					currentZone = Zone.matchZone(actorName);
				mappedActors.add(new Actor(actorName, mode, currentZone));
			}
		});
		return mappedActors;
	}
}
