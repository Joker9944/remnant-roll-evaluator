package online.vonarx.components;

import lombok.SneakyThrows;
import online.vonarx.models.AppParameters;
import org.apache.commons.io.IOUtils;

import javax.inject.Inject;
import java.net.URI;
import java.nio.file.Paths;

public class SaveBinaryProvider {

	private final URI saveFilepath;

	@Inject
	public SaveBinaryProvider(final AppParameters parameters) {
		saveFilepath = parameters.saveFilepath();
	}

	@SneakyThrows
	public byte[] provideSaveBinary() {
		return IOUtils.toByteArray(saveFilepath);
	}

	@SneakyThrows
	public byte[] provideProfileBinary() {
		final var profileUri = Paths.get(saveFilepath).resolveSibling("profile.sav").toUri();
		return IOUtils.toByteArray(profileUri);
	}
}
