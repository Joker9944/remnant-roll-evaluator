package online.vonarx.components;

import online.vonarx.formatter.Formatter;
import online.vonarx.models.AppParameters;

import javax.inject.Inject;

public class App {

	private final AppParameters appParameters;
	private final BinaryLoader binaryLoader;
	private final SaveFactory saveFactory;
	private final Formatter formatter;

	@Inject
	public App(final AppParameters appParameters,
	           final BinaryLoader binaryLoader, final SaveFactory saveFactory,
	           final Formatter formatter) {
		this.appParameters = appParameters;
		this.binaryLoader = binaryLoader;
		this.saveFactory = saveFactory;
		this.formatter = formatter;
	}

	public void run() {
		final var saveBinary = binaryLoader.readBinary(appParameters.saveFilepath());
		final var save = saveFactory.create(saveBinary);
		final var formattedSave = formatter.format(save);
	}
}
