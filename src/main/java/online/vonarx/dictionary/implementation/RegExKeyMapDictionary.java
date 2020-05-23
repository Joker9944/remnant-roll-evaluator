package online.vonarx.dictionary.implementation;

import online.vonarx.dictionary.Dictionary;

import java.util.Map;
import java.util.Optional;

public class RegExKeyMapDictionary<V> implements Dictionary<String, V> {

	private final Map<String, V> wrappedMap;

	public RegExKeyMapDictionary(final Map<String, V> dictionary) {
		wrappedMap = dictionary;
	}

	@Override
	public Optional<V> lookup(final String key) {
		return wrappedMap.entrySet().stream()
			.filter(entry -> key.matches(entry.getKey()))
			.findAny()
			.map(Map.Entry::getValue);
	}
}
