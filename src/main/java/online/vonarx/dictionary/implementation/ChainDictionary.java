package online.vonarx.dictionary.implementation;

import online.vonarx.dictionary.Dictionary;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ChainDictionary<K, V> implements Dictionary<K, V> {

	private final List<Dictionary<K, V>> dictionaries;


	@SafeVarargs
	public ChainDictionary(final Dictionary<K, V>... dictionaries) {
		this.dictionaries = Arrays.asList(dictionaries);
	}

	@Override
	public Optional<V> lookup(final K key) {
		return dictionaries.stream()
			.map(dictionary -> dictionary.lookup(key))
			.filter(Optional::isPresent)
			.map(Optional::get)
			.findFirst();
	}
}
