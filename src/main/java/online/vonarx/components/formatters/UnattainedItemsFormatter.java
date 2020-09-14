package online.vonarx.components.formatters;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import com.mitchtalmadge.asciidata.table.formats.TableFormatAbstract;
import online.vonarx.components.dictionaries.character.UnlockHintDictionary;
import online.vonarx.formatter.Formatter;
import online.vonarx.models.character.Character;

import javax.inject.Inject;

public class UnattainedItemsFormatter implements Formatter<Character> {

	private static final String[] UNATTAINED_TABLE_HEADER = new String[]{"Origin", "Type", "Name", "Unlock Hint"};

	private final TableFormatAbstract tableFormat;
	private final UnlockHintDictionary unlockHintDictionary;

	@Inject
	public UnattainedItemsFormatter(final TableFormatAbstract tableFormat,
	                                final UnlockHintDictionary unlockHintDictionary) {
		this.tableFormat = tableFormat;
		this.unlockHintDictionary = unlockHintDictionary;
	}

	@Override
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
