package online.vonarx.dictionary;

import java.util.Optional;

public abstract class DictionaryWrapper<K, V> implements Dictionary<K, V> {

	private final Dictionary<K, V> wrappedDictionary;

	protected DictionaryWrapper(final Dictionary<K, V> wrappedDictionary) {
		this.wrappedDictionary = wrappedDictionary;
	}

	@Override
	public Optional<V> lookup(final K key) {
		return wrappedDictionary.lookup(key);
	}
}
