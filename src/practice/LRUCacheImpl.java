package practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @param <K>
 * @param <V> Using a composite approach is better than using the inheritance.
 *            (HeadFirst Design Pattern)
 *            <p>
 *            This was asked in HP - ArcSight on-site.
 * @author Prachi
 *
 * Implement Object cache with Least Recently Used(LRU) eviction policy.
 */
public class LRUCacheImpl<K, V> {

    private final Map<K, V> cache;

    private final LinkedList<K> accessOrderForEviction;

    private final int capacity;

    public LRUCacheImpl(final int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        accessOrderForEviction = new LinkedList<>();
    }

    public static void main(String[] args) {
        LRUCacheImpl cache = new LRUCacheImpl(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.put(4, "Four");
        cache.get(3);
        cache.get(2);
        cache.put(1, "One");
        cache.get(3);
        cache.get(1);
        cache.printCacheContent();
    }

    public void put(K key, V value) {
        if (accessOrderForEviction.size() >= capacity) {
            K removedKey = accessOrderForEviction.removeLast();
            cache.remove(removedKey);
        }
        accessOrderForEviction.addFirst(key);
        cache.put(key, value);
    }

    public V get(K key) {
        V value = cache.get(key);
        if (null != value) {
            accessOrderForEviction.remove(key);
            accessOrderForEviction.addFirst(key);
        }
        return value;
    }

    public void printCacheContent() {
        for (Map.Entry<K, V> entry : cache.entrySet()) {
            System.out.println("Key=" + entry.getKey() + " and Value=" + entry.getValue());
        }
    }
}
