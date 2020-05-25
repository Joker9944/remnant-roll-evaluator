package online.vonarx.models;

import com.beust.jcommander.Parameter;
import lombok.Getter;
import online.vonarx.constants.Mode;
import online.vonarx.jcommander.RelativeURIConverter;

import java.net.URI;
import java.util.List;

public class AppParameters {

	private static final SaveFormatterType DEFAULT_PRINTER_TYPE = SaveFormatterType.TABLE;
	private static final List<Mode> DEFAULT_MODES_TO_PRINT = List.of(Mode.STORY);

	@Parameter(names = {"--file", "-f"}, description = "Path to remnant save", order = 0,
		required = true, converter = RelativeURIConverter.class)
	@Getter private URI saveFilepath;

	@Parameter(names = "--mode", description = "Which game modes should be printed", order = 1)
	@Getter private List<Mode> modes = DEFAULT_MODES_TO_PRINT;

	@Parameter(names = "--output-type", description = "How the output should be printed", order = 2)
	@Getter private SaveFormatterType printerType = DEFAULT_PRINTER_TYPE;

	@Parameter(names = "--identifiers", description = "Show actor identifiers", order = 3)
	@Getter private boolean showIdentifiers = false;

	@Parameter(names = "--redundant-actors", description = "Show redundant actors", order = 4)
	@Getter private boolean showRedundantActors = false;

	@Parameter(names = {"--help", "-h"}, description = "Print help", help = true, order = 5)
	@Getter private boolean printHelp = false;

	public enum SaveFormatterType {
		LIST, TABLE
	}
}
