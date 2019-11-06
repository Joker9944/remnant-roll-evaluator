package online.vonarx;

import online.vonarx.save.Save;
import online.vonarx.save.SavePrinter;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class Main {

	private static boolean showEngineNames = false;
	private static boolean showEngineActors = false;
	private static String path = null;

	public static void main(String[] args) throws IOException {
		readParameters(args);
		if (path == null) {
			System.out.println("Save path missing. Use --help for help.");
			return;
		}
		final var saveBinary = readSave(path);
		final var save = new Save(saveBinary);
		final var savePrinter = new SavePrinter(showEngineNames, showEngineActors);
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
				case "--engine-actors":
					showEngineActors = true;
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
			"      --engine-actors  Show actors which are used by the engine\n" +
			"      --engine-names   Show engine encounter names\n" +
			"  -h, --help           Show this guide :)");
	}
}
