package online.vonarx.save;

import online.vonarx.components.ActorFactory;
import online.vonarx.components.dictionaries.ZoneDictionary;
import online.vonarx.constants.Zone;
import online.vonarx.models.Actor;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public abstract class SaveFactory {

	private static final Pattern ACTOR_IDENTIFIER_PATTERN = Pattern.compile("/Game/[a-zA-Z0-9/._]+");
	private static final Pattern IS_TEMPLATE_PATTERN = Pattern.compile("^/Game/World_.+/Templates/.*$");

	private final ActorFactory actorFactory;
	private final ZoneDictionary zoneDictionary;

	public SaveFactory(final ActorFactory actorFactory, final ZoneDictionary zoneDictionary) {
		this.actorFactory = actorFactory;
		this.zoneDictionary = zoneDictionary;
	}

	public List<Actor> create(final byte[] saveBinary) {
		final var saveString = new String(saveBinary, StandardCharsets.UTF_8);
		final var identifiers = extractIdentifiers(saveString);
		final var extractedIdentifiers = extractIdentifiers(identifiers);
		return mapIdentifiersToActor(extractedIdentifiers);
	}

	private List<String> extractIdentifiers(final String save) {
		return ACTOR_IDENTIFIER_PATTERN.matcher(save).results()
			.map(MatchResult::group)
			.collect(toList());
	}

	protected abstract List<String> extractIdentifiers(final List<String> identifiers);

	private List<Actor> mapIdentifiersToActor(final List<String> identifiers) {
		final var mappedActors = new ArrayList<Actor>();
		var currentZone = Zone.NONE;
		for (final String identifier : identifiers) {
			if (IS_TEMPLATE_PATTERN.matcher(identifier).matches())
				currentZone = zoneDictionary.lookup(identifier)
					.orElse(Zone.NONE);
			mappedActors.add(actorFactory.create(currentZone, identifier));
		}
		return mappedActors;
	}
}
