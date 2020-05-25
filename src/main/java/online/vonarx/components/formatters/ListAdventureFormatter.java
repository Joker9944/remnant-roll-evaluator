package online.vonarx.components.formatters;

import online.vonarx.constants.Biome;
import online.vonarx.constants.Mode;
import online.vonarx.constants.Type;
import online.vonarx.constants.Zone;
import online.vonarx.formatter.ListFormatter;
import online.vonarx.models.Actor;
import online.vonarx.models.AppParameters;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class ListAdventureFormatter extends ListFormatter {

	@Inject
	public ListAdventureFormatter(final AppParameters parameters) {
		super(parameters);
	}

	@Override
	protected String formatList(final Map<Biome, Map<Zone, Map<Type, List<Actor>>>> groupedActors) {
		final var sb = new StringBuilder();
		groupedActors.forEach((biome, zones) -> {
			sb.append(Mode.ADVENTURE.displayName()).append(" (").append(biome.displayName()).append(")").append("\n");
			zones.values().forEach(types -> types.forEach((type, actors) -> {
				sb.append("\t").append(type.displayName()).append("\n");
				actors.forEach((actor) -> sb.append("\t").append(" - ").append(this.printActor(actor)).append("\n"));
			}));
		});
		return sb.toString();
	}
}
