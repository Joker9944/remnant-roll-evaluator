package online.vonarx.components.formatters;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import com.mitchtalmadge.asciidata.table.formats.TableFormatAbstract;
import online.vonarx.components.dictionaries.character.UnlockHintDictionary;
import online.vonarx.models.character.Character;

import javax.inject.Inject;

public class UnattainedItemsFormatter {

	private static final String[] UNATTAINED_TABLE_HEADER = new String[]{"Origin", "Type", "Name", "Unlock Hint"};

	private static final int ORIGIN_COLUMN = 0;
	private static final int TYPE_COLUMN = 1;
	private static final int NAME_COLUMN = 2;
	private static final int UNLOCK_HINT_COLUMN = 3;

	private final TableFormatAbstract tableFormat;
	private final UnlockHintDictionary unlockHintDictionary;

	@Inject
	public UnattainedItemsFormatter(final TableFormatAbstract tableFormat,
	                                final UnlockHintDictionary unlockHintDictionary) {
		this.tableFormat = tableFormat;
		this.unlockHintDictionary = unlockHintDictionary;
	}

	public String format(final Character character) {
		final var tableBody = character.unattainedItems().stream()
			.map(knownActor -> new String[]{
				knownActor.origin().displayName(),
				knownActor.type().displayName(),
				knownActor.displayName(),
				unlockHintDictionary.lookup(knownActor).orElse(null)
			}).toArray(String[][]::new);
		return ASCIITable.fromData(UNATTAINED_TABLE_HEADER, tableBody)
			.withTableFormat(tableFormat)
			.toString();
	}
}
