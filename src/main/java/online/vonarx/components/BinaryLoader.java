package online.vonarx.components;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import javax.inject.Inject;
import java.net.URI;

public class BinaryLoader {

	@Inject
	public BinaryLoader() {}

	@SneakyThrows
	public byte[] readBinary(final URI filePath) {
		return IOUtils.toByteArray(filePath);
	}
}
