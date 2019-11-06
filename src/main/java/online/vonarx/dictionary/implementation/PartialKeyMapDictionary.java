package online.vonarx.dictionary.implementation;

import online.vonarx.dictionary.Dictionary;

import java.util.Map;
import java.util.Optional;

public class PartialKeyMapDictionary<V> implements Dictionary<String, V> {

	private final Map<String, V> dictionaryMap;

	public PartialKeyMapDictionary(final Map<String, V> dictionaryMap) {
		this.dictionaryMap = dictionaryMap;
	}

	@Override
	public Optional<V> lookup(final String key) {
		return dictionaryMap.entrySet().stream()
			.filter(entry -> key.contains(entry.getKey()))
			.findAny()
			.map(Map.Entry::getValue);
	}
}
