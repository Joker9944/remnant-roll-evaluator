package online.vonarx.dictionary.implementation;

import online.vonarx.dictionary.Dictionary;

import java.util.Map;
import java.util.Optional;

public class MapDictionary<K, V> implements Dictionary<K, V> {

	private final Map<K, V> wrappedMap;

	public MapDictionary(final Map<K, V> dictionary) {
		this.wrappedMap = dictionary;
	}

	@Override
	public Optional<V> lookup(final K key) {
		return Optional.ofNullable(wrappedMap.get(key));
	}
}
