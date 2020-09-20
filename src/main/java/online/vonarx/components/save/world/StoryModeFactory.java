package online.vonarx.components.save.world;

import online.vonarx.components.dictionaries.character.ItemCraftingDictionary;
import online.vonarx.components.dictionaries.world.ZoneDictionary;
import online.vonarx.constants.world.Mode;
import online.vonarx.save.ModeFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.regex.Pattern;

public class StoryModeFactory extends ModeFactory {

	private static final String START_FROM_THE_ASHES = "/Game/Campaign_Main/Quest_Campaign_City.Quest_Campaign_City";
	private static final String END_FROM_THE_ASHES = "/Game/Campaign_Main/Quest_Campaign_Ward13.Quest_Campaign_Ward13";

	private static final Pattern START_SUBJECT_2923_PATTERN = Pattern.compile("^/Game/World_Rural/Templates/Template_Rural_Overworld_\\d{2}.Template_Rural_Overworld_\\d{2}$");
	private static final String END_SUBJECT_2923 = "/Game/Campaign_Clementine/Quests/WardPrime/Quest_Keycard_WardPrime.Quest_Keycard_WardPrime_C";

	@Inject
	public StoryModeFactory(final EncounterFactory encounterFactory, final ZoneDictionary zoneDictionary,
	                        final ItemCraftingDictionary itemCraftingDictionary) {
		super(encounterFactory, zoneDictionary, itemCraftingDictionary);
	}

	@Override
	protected List<String> extractIdentifiers(final List<String> identifiers) {
		final var startIndexFromTheAshes = identifiers.indexOf(START_FROM_THE_ASHES);
		final var endIndexFromTheAshes = identifiers.indexOf(END_FROM_THE_ASHES);
		if (startIndexFromTheAshes != -1 && endIndexFromTheAshes != -1) {
			// found From the Ashes campaign
			return identifiers.subList(startIndexFromTheAshes, endIndexFromTheAshes + 1);
		}
		final var startIndexSubject2923Identifier = identifiers.stream()
			.filter(identifier -> START_SUBJECT_2923_PATTERN.matcher(identifier).matches())
			.findFirst();
		final var endIndexSubject2923 = identifiers.lastIndexOf(END_SUBJECT_2923);
		if (startIndexSubject2923Identifier.isPresent() && endIndexSubject2923 != -1) {
			// found Subject 2923 campaign
			final var startIndexSubject2923 = identifiers.indexOf(startIndexSubject2923Identifier.get());
			return identifiers.subList(startIndexSubject2923, endIndexSubject2923 + 1);
		}
		throw new IllegalStateException("Could not find story mode.");
	}

	@Override
	protected Mode mode() {
		return Mode.STORY;
	}
}
