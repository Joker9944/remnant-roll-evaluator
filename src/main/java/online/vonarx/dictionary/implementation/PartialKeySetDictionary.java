package online.vonarx.dictionary.implementation;

import online.vonarx.dictionary.Dictionary;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PartialKeySetDictionary<V> extends HashSet<String> implements Dictionary<String, V> {

	private final V value;

	public PartialKeySetDictionary(final V value, final Set<String> keys) {
		this.value = value;
		addAll(keys);
	}

	@Override
	public Optional<V> lookup(final String key) {
		return stream().anyMatch(key::contains) ? Optional.of(value) : Optional.empty();
	}
}
