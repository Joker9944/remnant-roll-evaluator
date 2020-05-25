package online.vonarx.components.save;

import online.vonarx.components.ActorFactory;
import online.vonarx.components.dictionaries.ZoneDictionary;
import online.vonarx.save.SaveFactory;

import javax.inject.Inject;
import java.util.List;

public class StorySaveFactory extends SaveFactory {

	private static final String START_STORY_MODE = "/Game/Campaign_Main/Quest_Campaign_City.Quest_Campaign_City";
	private static final String END_STORY_MODE = "/Game/Campaign_Main/Quest_Campaign_Ward13.Quest_Campaign_Ward13";

	@Inject
	public StorySaveFactory(final ActorFactory actorFactory, final ZoneDictionary zoneDictionary) {
		super(actorFactory, zoneDictionary);
	}

	@Override
	protected List<String> extractIdentifiers(final List<String> identifiers) {
		final var startIndex = identifiers.indexOf(START_STORY_MODE);
		final var endIndex = identifiers.indexOf(END_STORY_MODE);
		if (startIndex == -1 || endIndex == -1)
			throw new IllegalStateException("Could not find story mode.");
		return identifiers.subList(startIndex, endIndex + 1);
	}
}
