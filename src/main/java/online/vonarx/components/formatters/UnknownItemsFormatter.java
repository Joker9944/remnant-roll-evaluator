package online.vonarx.components.formatters;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import com.mitchtalmadge.asciidata.table.formats.TableFormatAbstract;
import online.vonarx.formatter.Formatter;
import online.vonarx.models.character.Character;

import javax.inject.Inject;

public class UnknownItemsFormatter implements Formatter<Character> {

	private static final String[] UNKNOWN_TABLE_HEADER = new String[]{"Type", "Identifier"};

	private final TableFormatAbstract tableFormat;

	@Inject
	public UnknownItemsFormatter(final TableFormatAbstract tableFormat) {
		this.tableFormat = tableFormat;
	}

	@Override
	public String format(final Character character) {
		final var tableBody = character.unknownItems().stream()
			.map(unknownItem -> new String[]{unknownItem.type().displayName(), unknownItem.identifier()})
			.toArray(String[][]::new);
		return ASCIITable.fromData(UNKNOWN_TABLE_HEADER, tableBody)
			.withTableFormat(tableFormat)
			.toString();
	}
}
