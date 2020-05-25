package online.vonarx.components;

import com.google.common.collect.ImmutableMap;
import online.vonarx.constants.Mode;
import online.vonarx.formatter.Formatter;
import online.vonarx.models.Actor;
import online.vonarx.save.SaveFactory;

import javax.inject.Inject;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class App {

	private final BinaryProvider binaryProvider;
	private final PrintStream out;
	private final Map<Mode, SaveFactory> saveFactoryMap;
	private final Map<Mode, Formatter> formatterMap;

	@Inject
	public App(final BinaryProvider binaryProvider, final PrintStream out,
	           final Map<Mode, SaveFactory> saveFactoryMap,
	           final Map<Mode, Formatter> formatterMap) {
		this.binaryProvider = binaryProvider;
		this.out = out;
		this.saveFactoryMap = saveFactoryMap;
		this.formatterMap = formatterMap;
	}

	public void run() {
		final var saveBinary = binaryProvider.provideBinary();
		final var actorsByModeMapBuilder = ImmutableMap.<Mode, List<Actor>>builder();
		saveFactoryMap.forEach((mode, saveFactory) -> actorsByModeMapBuilder.put(mode, saveFactory.create(saveBinary)));
		final var actorsByMode = actorsByModeMapBuilder.build();
		formatterMap.forEach((mode, formatter) -> out.println(formatter.format(actorsByMode.get(mode))));
	}
}
