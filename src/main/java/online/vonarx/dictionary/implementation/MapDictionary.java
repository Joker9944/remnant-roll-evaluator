package online.vonarx.dictionary.implementation;

import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import online.vonarx.dictionary.Dictionary;

import java.util.Map;
import java.util.Optional;

public class MapDictionary<K, V> implements Dictionary<K, V> {

	private final Map<K, V> wrappedMap;

	private MapDictionary(final Map<K, V> dictionary) {
		this.wrappedMap = dictionary;
	}

	@Override
	public Optional<V> lookup(final K key) {
		return Optional.ofNullable(wrappedMap.get(key));
	}

	public static <K, V> MapDictionary.MapDictionaryBuilder<K, V> builder() {
		return new MapDictionary.MapDictionaryBuilder<>();
	}

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static class MapDictionaryBuilder<K, V> {

		private final ImmutableMap.Builder<K, V> wrappedMapBuilder = ImmutableMap.builder();

		public MapDictionary.MapDictionaryBuilder<K, V> put(final K partialKey, final V value) {
			wrappedMapBuilder.put(partialKey, value);
			return this;
		}

		public MapDictionary<K, V> build() {
			return new MapDictionary<>(wrappedMapBuilder.build());
		}
	}
}
