package online.vonarx.components.formatters;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import com.mitchtalmadge.asciidata.table.formats.TableFormatAbstract;
import online.vonarx.dictionary.Dictionary;
import online.vonarx.formatter.TableModeFormatter;
import online.vonarx.models.AppParameters;
import online.vonarx.models.world.encounter.Encounter;
import online.vonarx.models.world.rewards.RewardLine;

import javax.inject.Inject;
import java.util.List;

import static java.util.List.of;
import static java.util.stream.Collectors.joining;

public class TableAdventureModeFormatter extends TableModeFormatter {

	private static final String[] ADVENTURE_MODE_TABLE_HEADER_WITH_IDENTIFIER = new String[]{"Origin", "Type", "Name", "Subzone", "Unattained Rewards", "Identifier"};
	private static final String[] ADVENTURE_MODE_TABLE_HEADER_WITHOUT_IDENTIFIER = new String[]{"Origin", "Type", "Name", "Subzone", "Unattained Rewards"};

	private static final int ORIGIN_COLUMN = 0;
	private static final int TYPE_COLUMN = 1;
	private static final int NAME_COLUMN = 2;
	private static final int SUBZONE_COLUMN = 3;
	private static final int UNATTAINED_REWARDS_COLUMN = 4;
	private static final int IDENTIFIER_COLUMN = 5;

	private final boolean showIdentifiers;

	@Inject
	public TableAdventureModeFormatter(final AppParameters parameters, final TableFormatAbstract tableFormat) {
		super(parameters, tableFormat);
		this.showIdentifiers = parameters.showIdentifiers();
	}

	@Override
	protected String tableTitle(final List<Encounter> encounters) {
		if (encounters.size() == 0)
			return "Adventure";
		else
			return "Adventure (" + encounters.get(0).biome().displayName() + ")";
	}

	@Override
	protected ASCIITable formatTable(final List<Encounter> encounters, final Dictionary<Encounter, List<RewardLine>> unattainedRewardsDictionary,
	                                 final TableFormatAbstract tableFormat) {
		final String[] header;
		if (showIdentifiers)
			header = ADVENTURE_MODE_TABLE_HEADER_WITH_IDENTIFIER;
		else
			header = ADVENTURE_MODE_TABLE_HEADER_WITHOUT_IDENTIFIER;
		final var tableBody = encounters.stream()
			.map(encounter -> {
				final String[] row;
				if (showIdentifiers) {
					row = new String[ADVENTURE_MODE_TABLE_HEADER_WITH_IDENTIFIER.length];
					row[NAME_COLUMN] = encounter.displayName()
						.orElse(null);
					row[IDENTIFIER_COLUMN] = encounter.identifier();
				} else {
					row = new String[ADVENTURE_MODE_TABLE_HEADER_WITHOUT_IDENTIFIER.length];
					row[NAME_COLUMN] = encounter.displayName()
						.orElse(encounter.identifier());
				}
				row[ORIGIN_COLUMN] = encounter.origin().displayName();
				row[TYPE_COLUMN] = encounter.type().displayName();
				row[SUBZONE_COLUMN] = encounter.location()
					.orElse(null);
				row[UNATTAINED_REWARDS_COLUMN] = unattainedRewardsDictionary.lookup(encounter)
					.orElse(of())
					.stream()
					.map(reward -> "- " + reward.printReward())
					.collect(joining("\n"));
				return row;
			}).toArray(String[][]::new);
		return ASCIITable.fromData(header, tableBody)
			.withTableFormat(tableFormat);
	}
}
