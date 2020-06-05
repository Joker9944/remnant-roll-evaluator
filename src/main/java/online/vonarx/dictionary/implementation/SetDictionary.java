package online.vonarx.dictionary.implementation;

import com.google.common.collect.ImmutableSet;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import online.vonarx.dictionary.Dictionary;

import java.util.Optional;
import java.util.Set;

public class SetDictionary<K, V> implements Dictionary<K, V> {

	private final Set<K> keys;
	private final V value;

	private SetDictionary(final V value, final Set<K> keys) {
		this.keys = keys;
		this.value = value;
	}

	@Override
	public Optional<V> lookup(final K key) {
		return keys.contains(key) ? Optional.of(value) : Optional.empty();
	}

	public static <K, V> SetDictionaryBuilder<K, V> builder(final V value) {
		return new SetDictionaryBuilder<>(value);
	}

	@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
	public static class SetDictionaryBuilder<K, V> {

		private final ImmutableSet.Builder<K> keysBuilder = ImmutableSet.builder();
		private final V value;

		public SetDictionary.SetDictionaryBuilder<K, V> add(final K keys) {
			keysBuilder.add(keys);
			return this;
		}

		@SafeVarargs
		public final SetDictionary.SetDictionaryBuilder<K, V> add(final K... keys) {
			keysBuilder.add(keys);
			return this;
		}

		public final SetDictionary.SetDictionaryBuilder<K, V> allAdd(final Set<K> keySet) {
			keysBuilder.addAll(keySet);
			return this;
		}

		public SetDictionary<K, V> build() {
			return new SetDictionary<>(value, keysBuilder.build());
		}
	}
}
