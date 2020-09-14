package online.vonarx.components.formatters;

import online.vonarx.constants.Type;
import online.vonarx.constants.world.Biome;
import online.vonarx.constants.world.Zone;
import online.vonarx.formatter.ListModeFormatter;
import online.vonarx.models.AppParameters;
import online.vonarx.models.world.encounter.Encounter;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class ListStoryModeFormatter extends ListModeFormatter {

	@Inject
	public ListStoryModeFormatter(final AppParameters parameters) {
		super(parameters);
	}

	@Override
	protected String formatList(final Map<Biome, Map<Zone, Map<Type, List<Encounter>>>> groupedEncounters) {
		final var sb = new StringBuilder()
			.append("Story").append("\n");
		groupedEncounters.forEach((biome, zones) -> {
			sb.append("\t").append(biome.displayName()).append("\n");
			zones.forEach((zone, types) -> {
				sb.append("\t\t").append(zone.displayName()).append("\n");
				types.forEach((type, encounters) -> {
					sb.append("\t\t\t").append(type.displayName()).append("\n");
					encounters.forEach((encounter) -> sb.append("\t\t\t").append(" - ").append(this.printEncounter(encounter)).append("\n"));
				});
				sb.append("\n");
			});
		});
		return sb.toString();
	}
}
