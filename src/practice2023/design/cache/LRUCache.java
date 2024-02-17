package practice2023.design.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/submissions/
 * This implementation uses java's LinkedHashMap in which
 * order of INSERTION is preserved.
 *
 * The class overrides the removeEldestEntry method which is invoked
 * in put and putAll methods in order to ensure the capacity restrictions.
 * the over-ridden method will return true when the cache is over its capacity
 * which is when eviction will take place and remove the oldest INSERTED entry
 * To handle this scenario with each get call we will remove the entry from the
 * cache and re-insert it in the cache if the object is found in the cache.
 * So everytime we will have up-to-date object by its ACCESS order instead of
 * INSERTION order.
 *
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private final Map<Integer, Integer> cache;

    public LRUCache(int size) {
        this.cache = new LRULinkedHashMap(size);
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(5));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        cache.put(4, 4);
        cache.put(5, 5);
        System.out.println(cache.get(3));
        System.out.println(cache.get(5));
    }
    public int get(int key) {
        // re-insert the key in the map to keep last recently used
        // object up-to date
        int val = cache.getOrDefault(key, -1);
        if (val != -1) {
            cache.remove(key);
            cache.put(key, val);
        }
        return cache.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        // handle collision.
        if (cache.containsKey(key)) {
            int existingVal = cache.get(key);
            cache.remove(key);
            cache.put(key, existingVal);
        }
        cache.put(key, value);
    }
}

class LRULinkedHashMap extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
        return size() > capacity;
    }
    public LRULinkedHashMap(int capacity) {
        super();
        this.capacity = capacity;
    }
}