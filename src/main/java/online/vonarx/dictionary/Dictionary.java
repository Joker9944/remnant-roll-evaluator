package online.vonarx.dictionary;

import java.util.Optional;

public interface Dictionary<K, V> {

	Optional<V> lookup(final K key);
}
