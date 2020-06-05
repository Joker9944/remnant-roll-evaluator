package online.vonarx.components.save.world;

import online.vonarx.components.dictionaries.character.ItemCraftingDictionary;
import online.vonarx.components.dictionaries.world.ZoneDictionary;
import online.vonarx.constants.world.Mode;
import online.vonarx.save.ModeFactory;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class AdventureModeFactory extends ModeFactory {

	private static final Pattern START_ADVENTURE_MODE_PATTERN = Pattern.compile("^/Game/World_.+/Quests/Quest_AdventureMode/Quest_AdventureMode_[a-zA-Z]+_\\d{2}\\.Quest_AdventureMode_[a-zA-Z]+_\\d{2}$");
	private static final Pattern END_ADVENTURE_MODE_PATTERN = Pattern.compile("^/Game/World_.+/Quests/Quest_AdventureMode/Quest_AdventureMode_.+\\.Quest_AdventureMode_.+_C$");

	@Inject
	public AdventureModeFactory(final EncounterFactory encounterFactory, final ZoneDictionary zoneDictionary,
	                            final ItemCraftingDictionary itemCraftingDictionary) {
		super(encounterFactory, zoneDictionary, itemCraftingDictionary);
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

	@Override
	protected Mode mode() {
		return Mode.ADVENTURE;
	}
}
