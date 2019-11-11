package online.vonarx.dictionary.implementation;

import online.vonarx.dictionary.Dictionary;

import java.util.Optional;

public class RegExUnitDictionary<V> implements Dictionary<String, V> {

	private final String regEx;
	private final V value;

	public RegExUnitDictionary(final String regEx, final V value) {
		this.regEx = regEx;
		this.value = value;
	}

	@Override
	public Optional<V> lookup(final String key) {
		return key.matches(regEx) ? Optional.of(value) : Optional.empty();
	}
}
