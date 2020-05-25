package online.vonarx.dictionary.implementation;

import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import online.vonarx.dictionary.Dictionary;

import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

public class RegExKeyMapDictionary<V> implements Dictionary<String, V> {

	private final Map<Pattern, V> wrappedMap;

	private RegExKeyMapDictionary(final Map<Pattern, V> dictionary) {
		wrappedMap = dictionary;
	}

	@Override
	public Optional<V> lookup(final String key) {
		return wrappedMap.entrySet().stream()
			.filter(entry -> entry.getKey().matcher(key).matches())
			.findAny()
			.map(Map.Entry::getValue);
	}

	public static <V> RegExKeyMapDictionary.RegExKeyMapDictionaryBuilder<V> builder() {
		return new RegExKeyMapDictionary.RegExKeyMapDictionaryBuilder<>();
	}

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static class RegExKeyMapDictionaryBuilder<V> {

		private final ImmutableMap.Builder<Pattern, V> wrappedMapBuilder = ImmutableMap.builder();

		public RegExKeyMapDictionary.RegExKeyMapDictionaryBuilder<V> put(final String pattern, final V value) {
			wrappedMapBuilder.put(Pattern.compile(pattern), value);
			return this;
		}

		public RegExKeyMapDictionary<V> build() {
			return new RegExKeyMapDictionary<>(wrappedMapBuilder.build());
		}
	}
}
