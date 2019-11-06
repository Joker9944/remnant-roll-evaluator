package online.vonarx.dictionary.implementation;

import online.vonarx.dictionary.Dictionary;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ChainDictionary implements Dictionary<String, String> {

	private final List<Dictionary<String, String>> dictionaries;


	@SafeVarargs
	public ChainDictionary(final Dictionary<String, String>... dictionaries) {
		this.dictionaries = Arrays.asList(dictionaries);
	}

	@Override
	public Optional<String> lookup(final String key) {
		return dictionaries.stream()
			.map(dictionary -> dictionary.lookup(key))
			.filter(Optional::isPresent)
			.map(Optional::get)
			.findFirst();
	}
}
