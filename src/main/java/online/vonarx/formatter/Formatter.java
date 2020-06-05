package online.vonarx.formatter;

import lombok.RequiredArgsConstructor;
import online.vonarx.models.world.Encounter;
import online.vonarx.models.world.WorldSave;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
public abstract class Formatter {

	private static final int QUEST_IDENTIFIER_INDEX = 4;

	public static final Set<String> REDUNDANT_ACTORS = Set.of(
		"Quest_Event_Nexus", "Quest_Cryptolith_Labyrinth",
		"/Campaign_Main/", "/Quest_AdventureMode/",
		"/Templates/");

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
			.filter(encounter -> REDUNDANT_ACTORS.stream().noneMatch(redundantActor -> encounter.identifier().contains(redundantActor)))
			.collect(toList());
	}
}
