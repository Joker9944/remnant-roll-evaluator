package online.vonarx.dictionary.implementation;

import com.google.common.collect.ImmutableSet;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import online.vonarx.dictionary.Dictionary;

import java.util.Optional;
import java.util.Set;

public class PartialKeySetDictionary<V> implements Dictionary<String, V> {

	private final Set<String> partialKeys;
	private final V value;

	private PartialKeySetDictionary(final V value, final Set<String> partialKeys) {
		this.partialKeys = partialKeys;
		this.value = value;
	}

	@Override
	public Optional<V> lookup(final String key) {
		return partialKeys.stream()
			.anyMatch(key::contains) ? Optional.of(value) : Optional.empty();
	}

	public static <V> PartialKeySetDictionaryBuilder<V> builder(final V value) {
		return new PartialKeySetDictionaryBuilder<>(value);
	}

	@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
	public static class PartialKeySetDictionaryBuilder<V> {

		private final ImmutableSet.Builder<String> partialKeysBuilder = ImmutableSet.builder();
		private final V value;

		public PartialKeySetDictionaryBuilder<V> add(final String partialKey) {
			partialKeysBuilder.add(partialKey);
			return this;
		}

		public PartialKeySetDictionaryBuilder<V> add(final String... partialKeys) {
			partialKeysBuilder.add(partialKeys);
			return this;
		}

		public PartialKeySetDictionary<V> build() {
			return new PartialKeySetDictionary<>(value, partialKeysBuilder.build());
		}
	}
}
