package online.vonarx.dictionary.implementation;

import online.vonarx.dictionary.Dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RegExKeyMapDictionary<V> extends HashMap<String, V> implements Dictionary<String, V> {

	public RegExKeyMapDictionary(final Map<String, V> dictionaryMap) {
		super(dictionaryMap);
	}

	@Override
	public Optional<V> lookup(final String key) {
		return entrySet().stream()
			.filter(entry -> key.matches(entry.getKey()))
			.findFirst()
			.map(Map.Entry::getValue);
	}
}
