package online.vonarx;

import online.vonarx.save.Save;
import online.vonarx.save.SavePrinter;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class Main {

	private static boolean verbose = false;
	private static boolean showEngineNames = false;
	private static boolean showRedundantActors = false;
	private static String path = null;

	public static void main(String[] args) throws IOException {
		readParameters(args);
		if (path == null) {
			System.out.println("Save path missing. Use --help for help.");
			return;
		}
		final var saveBinary = readSave(path);
		final var save = new Save(saveBinary);
		final var savePrinter = new SavePrinter(verbose, showEngineNames, showRedundantActors);
		System.out.println(savePrinter.printSave(save));
	}

	private static void readParameters(final String[] args) {
		for (int i = 0; i < args.length; i++) {
			switch (args[i]) {
				case "--file":
				case "-f":
					try {
						path = args[++i];
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("No supplied path found, please check with --help.");
					}
					break;
				case "--engine-names":
					showEngineNames = true;
					break;
				case "--redundant":
					showRedundantActors = true;
					break;
				case "--verbose":
				case "-v":
					verbose = true;
					break;
				case "--help":
				case "-h":
					printHelp();
					break;
			}
		}
	}

	private static String readSave(final String path) throws IOException {
		return IOUtils.toString(Paths.get(path).toUri(), StandardCharsets.UTF_8);
	}

	private static void printHelp() {
		System.out.println("Usage:  remnant-roll-evaluator.exe --file {path_to_save}\n\n" +
			"Shows encounters in Remnant save.\n\n" +
			"Options:\n" +
			"  -f, --file string    Path to remnant save\n" +
			"  -v, --verbose        Show encounters belonging to other encounters\n" +
			"                       Example: The Beam Rifle belongs to The Lost Gantry so it would normally be hidden\n" +
			"      --redundant      Show encounters which spawn in every new game and game engine related encounters, does not affect adventure mode output\n" +
			"                       Example: Elf Queen and Undying King\n" +
			"      --engine-names   Show engine encounter names\n" +
			"  -h, --help           Show this guide :)");
	}
}
