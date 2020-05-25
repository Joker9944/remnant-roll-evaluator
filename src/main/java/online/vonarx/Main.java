package online.vonarx;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import online.vonarx.di.DaggerAppComponent;
import online.vonarx.models.AppParameters;

public class Main {

	private static final String PROGRAM_NAME = "remnant-roll-evaluator";
	private static final AppParameters appParameters = new AppParameters();
	private static final JCommander jCommander = JCommander.newBuilder()
		.programName(PROGRAM_NAME)
		.addObject(appParameters)
		.build();

	public static void main(final String[] args) {
		try {
			jCommander.parse(args);
		} catch (final ParameterException e) {
			jCommander.usage();
			return;
		}
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
