package online.vonarx;

import com.beust.jcommander.JCommander;
import online.vonarx.di.app.DaggerAppComponent;
import online.vonarx.models.AppParameters;

public class Main {

	private static final String PROGRAM_NAME = "remnant-roll-evaluator";
	private static final AppParameters appParameters = new AppParameters();
	private static final JCommander jCommander = JCommander.newBuilder()
		.programName(PROGRAM_NAME)
		.addObject(appParameters)
		.build();

	public static void main(final String[] args) {
		jCommander.parse(args);
		if (appParameters.printHelp()) {
			jCommander.usage();
			return;
		}
		DaggerAppComponent.factory()
			.create(appParameters)
			.app()
			.run();
	}
}
