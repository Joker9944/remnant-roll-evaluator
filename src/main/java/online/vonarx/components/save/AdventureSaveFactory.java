package online.vonarx.components.save;

import online.vonarx.components.ActorFactory;
import online.vonarx.components.dictionaries.ZoneDictionary;
import online.vonarx.save.SaveFactory;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class AdventureSaveFactory extends SaveFactory {

	private static final Pattern START_ADVENTURE_MODE_PATTERN = Pattern.compile("^/Game/World_.+/Quests/Quest_AdventureMode/Quest_AdventureMode_[a-zA-Z]+_\\d{2}\\.Quest_AdventureMode_[a-zA-Z]+_\\d{2}$");
	private static final Pattern END_ADVENTURE_MODE_PATTERN = Pattern.compile("^/Game/World_.+/Quests/Quest_AdventureMode/Quest_AdventureMode_.+\\.Quest_AdventureMode_.+_C$");

	@Inject
	public AdventureSaveFactory(final ActorFactory actorFactory, final ZoneDictionary zoneDictionary) {
		super(actorFactory, zoneDictionary);
	}

	@Override
	protected List<String> extractIdentifiers(final List<String> identifiers) {
		final var startIndexName = identifiers.stream()
			.filter(name -> START_ADVENTURE_MODE_PATTERN.matcher(name).matches())
			.reduce((first, second) -> second);
		final var endIndexName = identifiers.stream()
			.filter(name -> END_ADVENTURE_MODE_PATTERN.matcher(name).matches())
			.findFirst();
		if (startIndexName.isEmpty() || endIndexName.isEmpty()) {
			System.out.println("No adventure mode found.");
			return Collections.emptyList();
		}
		final var startIndex = identifiers.indexOf(startIndexName.get());
		final var endIndex = identifiers.indexOf(endIndexName.get());
		return identifiers.subList(startIndex, endIndex);
	}
}
