package online.vonarx.formatter;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import com.mitchtalmadge.asciidata.table.formats.TableFormatAbstract;
import online.vonarx.dictionary.Dictionary;
import online.vonarx.models.AppParameters;
import online.vonarx.models.world.WorldSave;
import online.vonarx.models.world.encounter.Encounter;
import online.vonarx.models.world.rewards.RewardLine;

import java.util.List;

public abstract class TableModeFormatter extends ModeFormatter {

	private final boolean showRedundantEncounters;
	private final TableFormatAbstract tableFormat;

	public TableModeFormatter(final AppParameters parameters, final TableFormatAbstract tableFormat) {
		this.showRedundantEncounters = parameters.showRedundantEncounters();
		this.tableFormat = tableFormat;
	}

	@Override
	public final String format(final WorldSave worldSave) {
		var encounters = worldSave.encounters();
		if (!showRedundantEncounters) {
			encounters = purgeDuplicateQuestEncounters(encounters);
			encounters = purgeRedundantEncounters(encounters);
		}
		return tableTitle(encounters) + "\n" + formatTable(encounters, worldSave.unattainedRewardsDictionary(), tableFormat).toString();
	}

	protected abstract String tableTitle(final List<Encounter> encounters);

	protected abstract ASCIITable formatTable(final List<Encounter> encounters, final Dictionary<Encounter, List<RewardLine>> unattainedRewardsDictionary,
	                                          final TableFormatAbstract tableFormat);
}
