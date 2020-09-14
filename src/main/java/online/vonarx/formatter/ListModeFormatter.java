package online.vonarx.formatter;

import online.vonarx.constants.Type;
import online.vonarx.constants.world.Biome;
import online.vonarx.constants.world.Zone;
import online.vonarx.models.AppParameters;
import online.vonarx.models.world.WorldSave;
import online.vonarx.models.world.encounter.Encounter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public abstract class ListModeFormatter extends ModeFormatter {

	private final boolean showIdentifiers;
	private final boolean showRedundantEncounters;

	public ListModeFormatter(final AppParameters parameters) {
		this.showIdentifiers = parameters.showIdentifiers();
		this.showRedundantEncounters = parameters.showRedundantEncounters();
	}

	@Override
	public final String format(final WorldSave worldSave) {
		var encounters = purgeDuplicateQuestEncounters(worldSave.encounters());
		if (!showRedundantEncounters)
			encounters = purgeRedundantEncounters(encounters);
		return formatList(groupEncounters(encounters));
	}

	protected abstract String formatList(final Map<Biome, Map<Zone, Map<Type, List<Encounter>>>> groupedEncounters);

	private Map<Biome, Map<Zone, Map<Type, List<Encounter>>>> groupEncounters(final List<Encounter> encounters) {
		return encounters.stream()
			.sorted(comparing(actor -> actor.displayName().orElse(actor.identifier())))
			.sorted(comparing(Encounter::type))
			.sorted(comparing(Encounter::zone))
			.sorted(comparing(Encounter::biome))
			.collect(
				groupingBy(Encounter::biome, LinkedHashMap::new,
					groupingBy(Encounter::zone, LinkedHashMap::new,
						groupingBy(Encounter::type, LinkedHashMap::new,
							toList()))));
	}

	protected String printEncounter(final Encounter encounter) {
		if (encounter.displayName().isEmpty()) {
			return encounter.identifier();
		} else if (showIdentifiers) {
			return encounter.displayName().get() + " (" + encounter.identifier() + ")";
		} else {
			return encounter.displayName().get();
		}
	}
}
