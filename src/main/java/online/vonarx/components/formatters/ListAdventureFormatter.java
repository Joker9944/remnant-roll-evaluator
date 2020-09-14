package online.vonarx.components.formatters;

import online.vonarx.constants.Type;
import online.vonarx.constants.world.Biome;
import online.vonarx.constants.world.Mode;
import online.vonarx.constants.world.Zone;
import online.vonarx.formatter.ListFormatter;
import online.vonarx.models.AppParameters;
import online.vonarx.models.world.encounter.Encounter;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class ListAdventureFormatter extends ListFormatter {

	@Inject
	public ListAdventureFormatter(final AppParameters parameters) {
		super(parameters);
	}

	@Override
	protected String formatList(final Map<Biome, Map<Zone, Map<Type, List<Encounter>>>> groupedEncounters) {
		final var sb = new StringBuilder();
		groupedEncounters.forEach((biome, zones) -> {
			sb.append(Mode.ADVENTURE.displayName()).append(" (").append(biome.displayName()).append(")").append("\n");
			zones.values().forEach(types -> types.forEach((type, encounters) -> {
				sb.append("\t").append(type.displayName()).append("\n");
				encounters.forEach((encounter) -> sb.append("\t").append(" - ").append(this.printEncounter(encounter)).append("\n"));
			}));
		});
		return sb.toString();
	}
}
