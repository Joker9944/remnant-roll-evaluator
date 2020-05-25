package online.vonarx.components;

import lombok.SneakyThrows;
import online.vonarx.models.AppParameters;
import org.apache.commons.io.IOUtils;

import javax.inject.Inject;

public class BinaryProvider {

	private final AppParameters parameters;

	@Inject
	public BinaryProvider(final AppParameters parameters) {this.parameters = parameters;}

	@SneakyThrows
	public byte[] provideBinary() {
		return IOUtils.toByteArray(parameters.saveFilepath());
	}
}
