package online.vonarx.dictionary.implementation;

import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import online.vonarx.dictionary.Dictionary;

import java.util.Map;
import java.util.Optional;

public class PartialKeyMapDictionary<V> implements Dictionary<String, V> {

	private final Map<String, V> wrappedMap;

	private PartialKeyMapDictionary(final Map<String, V> dictionary) {
		wrappedMap = dictionary;
	}

	@Override
	public Optional<V> lookup(final String key) {
		return wrappedMap.entrySet().stream()
			.filter(entry -> key.contains(entry.getKey()))
			.findAny()
			.map(Map.Entry::getValue);
	}

	public static <V> PartialKeyMapDictionaryBuilder<V> builder() {
		return new PartialKeyMapDictionaryBuilder<>();
	}

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static class PartialKeyMapDictionaryBuilder<V> {

		private final ImmutableMap.Builder<String, V> wrappedMapBuilder = ImmutableMap.builder();

		public PartialKeyMapDictionaryBuilder<V> put(final String partialKey, final V value) {
			wrappedMapBuilder.put(partialKey, value);
			return this;
		}

		public PartialKeyMapDictionaryBuilder<V> putAll(final Map<String, V> map) {
			wrappedMapBuilder.putAll(map);
			return this;
		}

		public PartialKeyMapDictionary<V> build() {
			return new PartialKeyMapDictionary<>(wrappedMapBuilder.build());
		}
	}
}
