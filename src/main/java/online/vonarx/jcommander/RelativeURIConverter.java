package online.vonarx.jcommander;

import com.beust.jcommander.converters.BaseConverter;

import java.net.URI;
import java.nio.file.Paths;

public class RelativeURIConverter extends BaseConverter<URI> {

	public RelativeURIConverter(final String optionName) {
		super(optionName);
	}

	@Override
	public URI convert(final String value) {
		return Paths.get(value).toUri();
	}
}
