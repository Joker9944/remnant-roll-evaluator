package online.vonarx;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import online.vonarx.actor.Mode;
import online.vonarx.save.Save;
import online.vonarx.save.printer.Printer;
import online.vonarx.save.printer.PrinterType;
import online.vonarx.save.printer.implementation.ListPrinter;
import online.vonarx.save.printer.implementation.TablePrinter;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {

	private static final String PROGRAM_NAME = "remnant-roll-evaluator";

	private static class Parameters {
		@Parameter(names = {"--file", "-f"}, description = "Path to remnant save", order = 0,
			required = true, converter = RelativeURIConverter.class)
		URI saveFilepath;

		@Parameter(names = "--mode", description = "Which game modes should be printed", order = 1)
		List<Mode> modes = List.of(Mode.STORY);

		@Parameter(names = "--output-type", description = "How the output should be printed", order = 2)
		PrinterType printerType = PrinterType.TABLE;

		@Parameter(names = "--identifiers", description = "Show actor identifiers", order = 3)
		boolean showIdentifiers = false;

		@Parameter(names = "--engine-actors", description = "Show engine encounter names", order = 4)
		boolean showEngineActors = false;

		@Parameter(names = {"--help", "-h"}, description = "Print help", help = true, order = 5)
		boolean printHelp = false;
	}

	private static Parameters parameters;
	private static JCommander jCommander;
	private static Save save;
	private static Printer<String> printer;

	public static void main(final String[] args) throws IOException {
		initializeParameters(args);
		if (parameters.printHelp) {
			jCommander.usage();
			return;
		}
		parseSave();
		initializePrinter();
		System.out.print(printer.print(save));
	}

	private static void initializeParameters(final String[] args) {
		parameters = new Parameters();
		jCommander = JCommander.newBuilder()
			.programName(PROGRAM_NAME)
			.addObject(parameters)
			.build();
		jCommander.parse(args);
	}

	private static void parseSave() throws IOException {
		final var saveBinary = IOUtils.toString(parameters.saveFilepath, StandardCharsets.UTF_8);
		save = new Save(saveBinary);
	}

	private static void initializePrinter() {
		if (parameters.printerType.equals(PrinterType.TABLE)) {
			printer = new TablePrinter(parameters.modes);
		} else {
			printer = new ListPrinter(parameters.modes, parameters.showIdentifiers, parameters.showEngineActors);
		}
	}
}
