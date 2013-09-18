package practice;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author Prachi
 * 
 * @param <K>
 * @param <V>
 * 
 *            Using a composite approach is better than using the inheritance.
 *            (HeadFirst Design Pattern)
 * 
 *            This was asked in HP - ArcSight on-site.
 */
public class LRUCacheImpl<K, V> implements LRUCache<K, V> {

	// SoftReference is used for a memory friendly cache.
	// the value will be removed under memory shortage situations and
	// the keys of the values will be removed from the cache map.
	private final Map<K, V> cache;

	public LRUCacheImpl(final int cacheSize) {

		// 'true' uses the access order instead of the insertion order.
		this.cache = new LinkeHashMapForCache<K, V>(cacheSize);
	}

	@Override
	public void put(K key, V value) {
		cache.put(key, value);
	}

	@Override
	public V get(K key) {
		return cache.get(key);
	}

	@Override
	public V atomicGetAndSet(K key, V value) {
		V result = get(key);
		put(key, value);
		return result;
	}
}

class LinkeHashMapForCache<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 1L;

	private int cacheSize;

	public LinkeHashMapForCache(int cacheSize) {

		// Set the access-order to true so that the map can provide
		// ordering mode by least recently used access order instead of by
		// insertion order.
		super(cacheSize, 0.75f, true);
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		// When to remove the eldest entry i.e Least Recently Used (i.e
		// LRU) entry
		return size() > cacheSize; // Size exceeded the max allowed.
	}
}