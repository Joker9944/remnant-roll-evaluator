package online.vonarx.components;

import online.vonarx.constants.Zone;
import online.vonarx.components.dictionaries.ZoneDictionary;
import online.vonarx.models.Actor;
import online.vonarx.models.Save;

import javax.inject.Inject;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class SaveFactory {

	private static final Pattern ACTOR_IDENTIFIER_PATTERN = Pattern.compile("/Game/[a-zA-Z0-9/._]+");

	private static final String START_STORY_MODE = "/Game/Campaign_Main/Quest_Campaign_City.Quest_Campaign_City";
	private static final String END_STORY_MODE = "/Game/Campaign_Main/Quest_Campaign_Ward13.Quest_Campaign_Ward13";

	private static final String START_ADVENTURE_MODE_REG_EX = "^/Game/World_.+/Quests/Quest_AdventureMode/Quest_AdventureMode_[a-zA-Z]+_\\d{2}\\.Quest_AdventureMode_[a-zA-Z]+_\\d{2}$";
	private static final String END_ADVENTURE_MODE_REG_EX = "^/Game/World_.+/Quests/Quest_AdventureMode/Quest_AdventureMode_.+\\.Quest_AdventureMode_.+_C$";

	private static final String IS_TEMPLATE_REG_EX = "^/Game/World_.+/Templates/.*$";

	private final ActorFactory actorFactory;
	private final ZoneDictionary zoneDictionary;

	@Inject
	public SaveFactory(final ActorFactory actorFactory, final ZoneDictionary zoneDictionary) {
		this.actorFactory = actorFactory;
		this.zoneDictionary = zoneDictionary;
	}

	public Save create(final byte[] saveBinary) {
		final var saveString = new String(saveBinary, StandardCharsets.UTF_8);
		final var allActorIdentifiers = extractActorIdentifiers(saveString);
		final var storyActors = extractStoryModeActors(allActorIdentifiers);
		final var adventureActors = extractAdventureMode(allActorIdentifiers);
		return new Save(storyActors, adventureActors);
	}

	private List<String> extractActorIdentifiers(final String save) {
		return ACTOR_IDENTIFIER_PATTERN.matcher(save).results()
			.map(MatchResult::group)
			.collect(toList());
	}

	private List<Actor> extractStoryModeActors(final List<String> unfilteredActorIdentifiers) {
		final var startIndex = unfilteredActorIdentifiers.indexOf(START_STORY_MODE);
		final var endIndex = unfilteredActorIdentifiers.indexOf(END_STORY_MODE);
		if (startIndex == -1 || endIndex == -1)
			throw new IllegalStateException("Could not find story mode.");
		final var identifiers = unfilteredActorIdentifiers.subList(startIndex, endIndex + 1);
		return mapIdentifiersToActor(identifiers);
	}

	private List<Actor> extractAdventureMode(final List<String> unfilteredActorIdentifiers) {
		final var startIndexName = unfilteredActorIdentifiers.stream()
			.filter(name -> name.matches(START_ADVENTURE_MODE_REG_EX))
			.reduce((first, second) -> second);
		final var endIndexName = unfilteredActorIdentifiers.stream()
			.filter(name -> name.matches(END_ADVENTURE_MODE_REG_EX))
			.findFirst();
		if (startIndexName.isEmpty() || endIndexName.isEmpty()) {
			System.out.println("No adventure mode found.");
			return Collections.emptyList();
		}
		final var startIndex = unfilteredActorIdentifiers.indexOf(startIndexName.get());
		final var endIndex = unfilteredActorIdentifiers.indexOf(endIndexName.get());
		final var identifiers = unfilteredActorIdentifiers.subList(startIndex, endIndex);
		return mapIdentifiersToActor(identifiers);
	}

	private List<Actor> mapIdentifiersToActor(final List<String> identifiers) {
		final var mappedActors = new ArrayList<Actor>();
		var currentZone = Zone.NONE;
		for (final String identifier : identifiers) {
			if (identifier.matches(IS_TEMPLATE_REG_EX))
				currentZone = zoneDictionary.lookup(identifier)
					.orElse(Zone.NONE);
			mappedActors.add(actorFactory.create(currentZone, identifier));
		}
		return mappedActors;
	}
}
