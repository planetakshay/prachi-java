package practice;

public interface LRUCache<K, V> {

	public void put(K key, V item);

	public V get(K key);

	public V atomicGetAndSet(K key, V item);

}
