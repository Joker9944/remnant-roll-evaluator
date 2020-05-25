package online.vonarx.components.formatters;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import com.mitchtalmadge.asciidata.table.formats.TableFormatAbstract;
import online.vonarx.formatter.TableFormatter;
import online.vonarx.models.Actor;
import online.vonarx.models.AppParameters;

import javax.inject.Inject;
import java.util.List;

public class TableStoryFormatter extends TableFormatter {

	private static final String[] STORY_MODE_TABLE_HEADER_WITH_IDENTIFIER = new String[]{"Origin", "Type", "Name", "Biome", "Zone", "Subzone", "Identifier"};
	private static final String[] STORY_MODE_TABLE_HEADER_WITHOUT_IDENTIFIER = new String[]{"Origin", "Type", "Name", "Biome", "Zone", "Subzone"};

	private static final int ORIGIN_COLUMN = 0;
	private static final int TYPE_COLUMN = 1;
	private static final int NAME_COLUMN = 2;
	private static final int BIOME_COLUMN = 3;
	private static final int ZONE_COLUMN = 4;
	private static final int SUBZONE_COLUMN = 5;
	private static final int IDENTIFIER_COLUMN = 6;

	private final boolean showIdentifiers;

	@Inject
	public TableStoryFormatter(final AppParameters parameters, final TableFormatAbstract tableFormat) {
		super(parameters, tableFormat);
		this.showIdentifiers = parameters.showIdentifiers();
	}

	@Override
	protected String tableTitle(final List<Actor> actors) {
		return "Story";
	}

	@Override
	protected ASCIITable formatTable(final List<Actor> actors, final TableFormatAbstract tableFormat) {
		final String[] header;
		if (showIdentifiers)
			header = STORY_MODE_TABLE_HEADER_WITH_IDENTIFIER;
		else
			header = STORY_MODE_TABLE_HEADER_WITHOUT_IDENTIFIER;
		final var tableBody = actors.stream()
			.map(actor -> {
				final String[] row;
				if (showIdentifiers) {
					row = new String[STORY_MODE_TABLE_HEADER_WITH_IDENTIFIER.length];
					row[NAME_COLUMN] = actor.name()
						.orElse(null);
					row[IDENTIFIER_COLUMN] = actor.identifier();
				} else {
					row = new String[STORY_MODE_TABLE_HEADER_WITHOUT_IDENTIFIER.length];
					row[NAME_COLUMN] = actor.name()
						.orElse(actor.identifier());
				}
				row[ORIGIN_COLUMN] = actor.origin().displayName();
				row[TYPE_COLUMN] = actor.type().displayName();
				row[BIOME_COLUMN] = actor.biome().displayName();
				row[ZONE_COLUMN] = actor.zone().displayName();
				row[SUBZONE_COLUMN] = actor.subZone()
					.orElse(null);
				return row;
			}).toArray(String[][]::new);
		return ASCIITable.fromData(header, tableBody)
			.withTableFormat(tableFormat);
	}
}
