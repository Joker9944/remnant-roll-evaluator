package online.vonarx.dictionary.implementation;

import online.vonarx.dictionary.Dictionary;

import java.util.Optional;
import java.util.Set;

public class PartialKeySetDictionary<V> implements Dictionary<String, V> {

	private final Set<String> partialKeys;
	private final V value;

	public PartialKeySetDictionary(final V value, final Set<String> partialKeys) {
		this.partialKeys = partialKeys;
		this.value = value;
	}

	@Override
	public Optional<V> lookup(final String key) {
		return partialKeys.stream()
			.anyMatch(key::contains) ? Optional.of(value) : Optional.empty();
	}
}
