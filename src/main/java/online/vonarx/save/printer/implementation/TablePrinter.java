package online.vonarx.save.printer.implementation;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import com.mitchtalmadge.asciidata.table.formats.ASCIITableFormat;
import online.vonarx.actor.Actor;
import online.vonarx.actor.Mode;
import online.vonarx.save.Save;
import online.vonarx.save.printer.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.groupingBy;

public class TablePrinter extends Printer<String> {

	private static final String[] STORY_MODE_TABLE_HEADER_WITH_IDENTIFIER = new String[]{"Origin", "Type", "Name", "Biome", "Zone", "Subzone", "Identifier"};
	private static final String[] ADVENTURE_MODE_TABLE_HEADER_WITH_IDENTIFIER = new String[]{"Origin", "Type", "Name", "Subzone", "Identifier"};
	private static final String[] STORY_MODE_TABLE_HEADER_WITHOUT_IDENTIFIER = new String[]{"Origin", "Type", "Name", "Biome", "Zone", "Subzone"};
	private static final String[] ADVENTURE_MODE_TABLE_HEADER_WITHOUT_IDENTIFIER = new String[]{"Origin", "Type", "Name", "Subzone"};

	private final boolean showIdentifiers;
	private final boolean showEngineActors;

	public TablePrinter(final List<Mode> modesToShow, final boolean showIdentifiers, final boolean showEngineActors) {
		super(modesToShow);
		this.showIdentifiers = showIdentifiers;
		this.showEngineActors = showEngineActors;
	}

	private static ASCIITable createStoryTableFromActorsWithIdentifier(final List<Actor> actors) {
		final var tableBody = actors.stream()
			.map(actor -> new String[]{
				actor.origin().displayName(),
				actor.type().displayName(),
				actor.name()
					.orElse(null),
				actor.biome().displayName(),
				actor.zone().displayName(),
				actor.subZone()
					.orElse(null),
				actor.identifier()})
			.toArray(String[][]::new);
		return ASCIITable.fromData(STORY_MODE_TABLE_HEADER_WITH_IDENTIFIER, tableBody)
			.withTableFormat(new ASCIITableFormat());
	}

	private static ASCIITable createStoryTableFromActorsWithoutIdentifier(final List<Actor> actors) {
		final var tableBody = actors.stream()
			.map(actor -> new String[]{
				actor.origin().displayName(),
				actor.type().displayName(),
				actor.name()
					.orElse(actor.identifier()),
				actor.biome().displayName(),
				actor.zone().displayName(),
				actor.subZone()
					.orElse(null)})
			.toArray(String[][]::new);
		return ASCIITable.fromData(STORY_MODE_TABLE_HEADER_WITHOUT_IDENTIFIER, tableBody)
			.withTableFormat(new ASCIITableFormat());
	}

	private static ASCIITable createAdventureTableFromActorsWithIdentifier(final List<Actor> actors) {
		final var tableBody = actors.stream()
			.map(actor -> new String[]{
				actor.origin().displayName(),
				actor.type().displayName(),
				actor.name()
					.orElse(null),
				actor.subZone()
					.orElse(null),
				actor.identifier()})
			.toArray(String[][]::new);
		return ASCIITable.fromData(ADVENTURE_MODE_TABLE_HEADER_WITH_IDENTIFIER, tableBody)
			.withTableFormat(new ASCIITableFormat());
	}

	private static ASCIITable createAdventureTableFromActorsWithoutIdentifier(final List<Actor> actors) {
		final var tableBody = actors.stream()
			.map(actor -> new String[]{
				actor.origin().displayName(),
				actor.type().displayName(),
				actor.name()
					.orElse(actor.identifier()),
				actor.subZone()
					.orElse(null)})
			.toArray(String[][]::new);
		return ASCIITable.fromData(ADVENTURE_MODE_TABLE_HEADER_WITHOUT_IDENTIFIER, tableBody)
			.withTableFormat(new ASCIITableFormat());
	}

	@Override
	public String print(final Save save) {
		final var actors = new ArrayList<>(save.actors());
		filterActorsByMode(actors);
		if (!showEngineActors) {
			purgeDuplicateQuestEntries(actors);
			purgeRedundantActors(actors);
		}
		final var actorsByMode = actors.stream()
			.collect(groupingBy(Actor::mode));
		final var sb = new StringBuilder();
		if (Objects.nonNull(actorsByMode.get(Mode.STORY)))
			sb.append("Story\n").append(createStoryTableFromActors(actorsByMode.get(Mode.STORY)));
		if (sb.length() != 0)
			sb.append("\n");
		if (Objects.nonNull(actorsByMode.get(Mode.ADVENTURE)))
			sb.append("Adventure\n").append(createAdventureTableFromActors(actorsByMode.get(Mode.ADVENTURE)));
		return sb.toString();
	}

	private ASCIITable createStoryTableFromActors(final List<Actor> actors) {
		return showIdentifiers ? createStoryTableFromActorsWithIdentifier(actors) :
			createStoryTableFromActorsWithoutIdentifier(actors);
	}

	private ASCIITable createAdventureTableFromActors(final List<Actor> actors) {
		return showIdentifiers ? createAdventureTableFromActorsWithIdentifier(actors) :
			createAdventureTableFromActorsWithoutIdentifier(actors);
	}
}
