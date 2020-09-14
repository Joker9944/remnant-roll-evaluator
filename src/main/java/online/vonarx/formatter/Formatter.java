package online.vonarx.formatter;

import lombok.RequiredArgsConstructor;
import online.vonarx.constants.Type;
import online.vonarx.models.world.WorldSave;
import online.vonarx.models.world.encounter.Encounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static online.vonarx.constants.Type.MAIN_QUEST;
import static online.vonarx.constants.Type.TEMPLATE;

@RequiredArgsConstructor
public abstract class Formatter {

	private static final int QUEST_IDENTIFIER_INDEX = 4;

	public static final Set<String> REDUNDANT_PARTIAL_IDENTIFIERS = Set.of(
		"Quest_Event_Nexus", "Quest_Cryptolith_Labyrinth",
		"Quest_AdventureMode"
	);

	public static final Set<Type> REDUNDANT_TYPES = Set.of(
		MAIN_QUEST, TEMPLATE
	);

	public abstract String format(final WorldSave worldSave);

	protected List<Encounter> purgeDuplicateQuestEncounters(final List<Encounter> encounters) {
		final List<String> knownQuestsIdentifiers = new ArrayList<>();
		return encounters.stream()
			.filter(encounter -> {
				if (!encounter.identifier().contains("/Quests/"))
					return true;
				final var questIdentifier = encounter.identifier().split("/")[QUEST_IDENTIFIER_INDEX];
				if (knownQuestsIdentifiers.contains(questIdentifier))
					return false;
				else {
					knownQuestsIdentifiers.add(questIdentifier);
					return true;
				}
			}).collect(toList());
	}

	protected List<Encounter> purgeRedundantEncounters(final List<Encounter> encounters) {
		return encounters.stream()
			.filter(encounter -> REDUNDANT_TYPES.stream().noneMatch(type -> encounter.type().equals(type)))
			.filter(encounter -> REDUNDANT_PARTIAL_IDENTIFIERS.stream().noneMatch(redundantActor -> encounter.identifier().contains(redundantActor)))
			.collect(toList());
	}
}
