package online.vonarx.dictionary.implementation;

import online.vonarx.dictionary.Dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapDictionary<K, V> extends HashMap<K, V> implements Dictionary<K, V> {

	public MapDictionary(final Map<K, V> map) {
		putAll(map);
	}

	@Override
	public Optional<V> lookup(final K key) {
		return Optional.ofNullable(get(key));
	}
}
