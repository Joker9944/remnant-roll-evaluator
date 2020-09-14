package online.vonarx.components;

import online.vonarx.components.formatters.UnattainedItemsFormatter;
import online.vonarx.components.formatters.UnknownItemsFormatter;
import online.vonarx.components.save.character.CharacterFactory;
import online.vonarx.constants.world.Mode;
import online.vonarx.formatter.ModeFormatter;
import online.vonarx.save.ModeFactory;

import javax.inject.Inject;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class App {

	private final SaveBinaryProvider saveBinaryProvider;
	private final PrintStream out;
	private final CharacterFactory characterFactory;
	private final List<ModeFactory> saveFactories;
	private final Map<Mode, ModeFormatter> formatterMap;
	private final UnattainedItemsFormatter unattainedItemsFormatter;
	private final UnknownItemsFormatter unknownItemsFormatter;

	@Inject
	public App(final SaveBinaryProvider saveBinaryProvider, final PrintStream out,
	           final CharacterFactory characterFactory,
	           final List<ModeFactory> saveFactories,
	           final Map<Mode, ModeFormatter> formatterMap,
	           final UnattainedItemsFormatter unattainedItemsFormatter,
	           final UnknownItemsFormatter unknownItemsFormatter) {
		this.saveBinaryProvider = saveBinaryProvider;
		this.out = out;
		this.characterFactory = characterFactory;
		this.saveFactories = saveFactories;
		this.formatterMap = formatterMap;
		this.unattainedItemsFormatter = unattainedItemsFormatter;
		this.unknownItemsFormatter = unknownItemsFormatter;
	}

	public void run() {
		final var profileBinary = saveBinaryProvider.provideProfileBinary();
		final var character = characterFactory.create(profileBinary);

		final var saveBinary = saveBinaryProvider.provideSaveBinary();
		final var worldSaves = saveFactories.stream()
			.map(modeFactory -> modeFactory.create(saveBinary, character))
			.collect(toList());

		worldSaves.forEach(worldSave -> out.println(formatterMap.get(worldSave.mode()).format(worldSave)));
		out.println(unattainedItemsFormatter.format(character));
		out.println(unknownItemsFormatter.format(character));
	}
}
