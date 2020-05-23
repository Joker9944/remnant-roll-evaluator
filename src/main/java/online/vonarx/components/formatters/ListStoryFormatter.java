package online.vonarx.components.formatters;

import online.vonarx.constants.Biome;
import online.vonarx.constants.Mode;
import online.vonarx.constants.Type;
import online.vonarx.constants.Zone;
import online.vonarx.formatter.ListFormatter;
import online.vonarx.models.Actor;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class ListStoryFormatter extends ListFormatter {

	@Inject
	public ListStoryFormatter(final boolean showIdentifiers, final boolean showEngineActors) {
		super(showIdentifiers, showEngineActors);
	}

	@Override
	protected String formatList(final Map<Biome, Map<Zone, Map<Type, List<Actor>>>> groupedActors) {
		final var sb = new StringBuilder();
		groupedActors.forEach((biome, zones) -> {
			sb.append(biome.displayName()).append("\n");
			zones.forEach((zone, types) -> {
				sb.append("\t").append(zone.displayName()).append("\n");
				types.forEach((type, actors) -> {
					sb.append("\t\t").append(type.displayName()).append("\n");
					actors.forEach((actor) -> sb.append("\t\t - ").append(this.printActor(actor)).append("\n"));
				});
				sb.append("\n");
			});
		});
		return sb.toString();
	}
}
