package online.vonarx.dictionary.implementation;

import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import online.vonarx.dictionary.Dictionary;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

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
		private final Set<K> addedKeys = new HashSet<>();

		public MapDictionary.MapDictionaryBuilder<K, V> put(final K key, final V value) {
			wrappedMapBuilder.put(key, value);
			addedKeys.add(key);
			return this;
		}

		public MapDictionary.MapDictionaryBuilder<K, V> putAll(final Map<K, V> map) {
			wrappedMapBuilder.putAll(map);
			addedKeys.addAll(map.keySet());
			return this;
		}

		public boolean contains(final K key) {
			return addedKeys.contains(key);
		}

		public MapDictionary<K, V> build() {
			return new MapDictionary<>(wrappedMapBuilder.build());
		}
	}
}
