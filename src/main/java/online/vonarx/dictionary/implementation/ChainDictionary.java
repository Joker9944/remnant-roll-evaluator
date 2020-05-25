package online.vonarx.dictionary.implementation;

import com.google.common.collect.ImmutableList;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import online.vonarx.dictionary.Dictionary;

import java.util.List;
import java.util.Optional;

public class ChainDictionary<K, V> implements Dictionary<K, V> {

	private final List<Dictionary<K, V>> dictionaries;

	private ChainDictionary(final List<Dictionary<K, V>> dictionaries) {
		this.dictionaries = dictionaries;
	}

	@Override
	public Optional<V> lookup(final K key) {
		return dictionaries.stream()
			.map(dictionary -> dictionary.lookup(key))
			.filter(Optional::isPresent)
			.map(Optional::get)
			.findFirst();
	}

	public static <K, V> ChainDictionaryBuilder<K, V> builder() {
		return new ChainDictionaryBuilder<>();
	}

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static class ChainDictionaryBuilder<K, V> {

		private final ImmutableList.Builder<Dictionary<K, V>> dictionariesBuilder = ImmutableList.builder();

		public ChainDictionary.ChainDictionaryBuilder<K, V> addDictionary(final Dictionary<K, V> dictionary) {
			dictionariesBuilder.add(dictionary);
			return this;
		}

		public ChainDictionary<K, V> build() {
			return new ChainDictionary<>(dictionariesBuilder.build());
		}
	}
}
