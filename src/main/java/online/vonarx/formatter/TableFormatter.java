package online.vonarx.formatter;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import com.mitchtalmadge.asciidata.table.formats.TableFormatAbstract;
import online.vonarx.models.Actor;

import java.util.List;

public abstract class TableFormatter extends Formatter {

	private final boolean hideRedundantActors;
	private final TableFormatAbstract tableFormat;

	public TableFormatter(final boolean hideRedundantActors, final TableFormatAbstract tableFormat) {
		this.hideRedundantActors = hideRedundantActors;
		this.tableFormat = tableFormat;
	}

	@Override
	public final String format(final List<Actor> actors) {
		if (hideRedundantActors) {
			purgeDuplicateQuestEntries(actors);
			purgeRedundantActors(actors);
		}
		return formatTable(actors, tableFormat).toString();
	}

	protected abstract ASCIITable formatTable(final List<Actor> actors, final TableFormatAbstract tableFormat);
}
