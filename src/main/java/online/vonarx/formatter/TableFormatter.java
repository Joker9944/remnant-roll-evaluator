package online.vonarx.formatter;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import com.mitchtalmadge.asciidata.table.formats.TableFormatAbstract;
import online.vonarx.models.Actor;
import online.vonarx.models.AppParameters;

import java.util.List;

public abstract class TableFormatter extends Formatter {

	private final boolean showRedundantActors;
	private final TableFormatAbstract tableFormat;

	public TableFormatter(final AppParameters parameters, final TableFormatAbstract tableFormat) {
		this.showRedundantActors = parameters.showRedundantActors();
		this.tableFormat = tableFormat;
	}

	@Override
	public final String format(List<Actor> actors) {
		if (!showRedundantActors) {
			actors = purgeDuplicateQuestEntries(actors);
			actors = purgeRedundantActors(actors);
		}
		return tableTitle(actors) + "\n" + formatTable(actors, tableFormat).toString();
	}

	protected abstract String tableTitle(final List<Actor> actors);

	protected abstract ASCIITable formatTable(final List<Actor> actors, final TableFormatAbstract tableFormat);
}
