package online.vonarx.dictionary.implementation;

import online.vonarx.dictionary.Dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PartialKeyMapDictionary<V> extends HashMap<String, V> implements Dictionary<String, V> {

	public PartialKeyMapDictionary(final Map<String, V> dictionaryMap) {
		putAll(dictionaryMap);
	}

	@Override
	public Optional<V> lookup(final String key) {
		return entrySet().stream()
			.filter(entry -> key.contains(entry.getKey()))
			.findAny()
			.map(Map.Entry::getValue);
	}
}
