package online.vonarx.save.printer.implementation;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import com.mitchtalmadge.asciidata.table.formats.ASCIITableFormat;
import online.vonarx.actor.Actor;
import online.vonarx.actor.Mode;
import online.vonarx.dictionary.LocationDictionary;
import online.vonarx.save.Save;
import online.vonarx.save.printer.Printer;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;

public class TablePrinter extends Printer<String> {

	private static final String[] STORY_MODE_TABLE_HEADER = new String[]{"Biome", "Zone", "Subzone", "Name", "Engine name"};
	private static final String[] ADVENTURE_MODE_TABLE_HEADER = new String[]{"Subzone", "Name", "Engine name"};

	@Override
	public String print(final Save save) {
		final var actorsByMode = save.actors().stream()
			.collect(groupingBy(Actor::mode));
		final var storyTable = createStoryTableFromActors(actorsByMode.get(Mode.STORY));
		final var adventureTable = createAdventureTableFromActors(actorsByMode.get(Mode.ADVENTURE));
		return "Story\n" + storyTable.toString() + "\nAdventure\n" + adventureTable.toString();
	}

	private static ASCIITable createStoryTableFromActors(final List<Actor> actors) {
		final var tableBody = actors.stream()
			.map(actor -> new String[]{
				actor.biome().displayName(),
				actor.zone().displayName(),
				LocationDictionary.dictionary.lookup(actor.name())
					.orElse(null),
				actor.displayName()
					.orElse(null),
				actor.name()})
			.toArray(String[][]::new);
		return ASCIITable.fromData(STORY_MODE_TABLE_HEADER, tableBody)
			.withTableFormat(new ASCIITableFormat());
	}

	private static ASCIITable createAdventureTableFromActors(final List<Actor> actors) {
		final var tableBody = actors.stream()
			.map(actor -> new String[]{
				LocationDictionary.dictionary.lookup(actor.name())
					.orElse(null),
				actor.displayName()
					.orElse(null),
				actor.name()})
			.toArray(String[][]::new);
		return ASCIITable.fromData(ADVENTURE_MODE_TABLE_HEADER, tableBody)
			.withTableFormat(new ASCIITableFormat());
	}
}
