package online.vonarx.components.save.world;

import online.vonarx.components.dictionaries.character.ItemCraftingDictionary;
import online.vonarx.components.dictionaries.world.ZoneDictionary;
import online.vonarx.constants.world.Mode;
import online.vonarx.save.ModeFactory;

import javax.inject.Inject;
import java.util.List;

public class StoryModeFactory extends ModeFactory {

	private static final String START_STORY_MODE = "/Game/Campaign_Main/Quest_Campaign_City.Quest_Campaign_City";
	private static final String END_STORY_MODE = "/Game/Campaign_Main/Quest_Campaign_Ward13.Quest_Campaign_Ward13";

	@Inject
	public StoryModeFactory(final EncounterFactory encounterFactory, final ZoneDictionary zoneDictionary,
	                        final ItemCraftingDictionary itemCraftingDictionary) {
		super(encounterFactory, zoneDictionary, itemCraftingDictionary);
	}

	@Override
	protected List<String> extractIdentifiers(final List<String> identifiers) {
		final var startIndex = identifiers.indexOf(START_STORY_MODE);
		final var endIndex = identifiers.indexOf(END_STORY_MODE);
		if (startIndex == -1 || endIndex == -1)
			throw new IllegalStateException("Could not find story mode.");
		return identifiers.subList(startIndex, endIndex + 1);
	}

	@Override
	protected Mode mode() {
		return Mode.STORY;
	}
}
