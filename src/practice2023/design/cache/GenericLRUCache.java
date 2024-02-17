package practice2023.design.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class GenericLRUCache <K, V>{
    private Map<K, V> cache;
    private int capacity;

    public GenericLRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K,V> entry) {
                return size() >= capacity;
            }
        };
    }

    public V get(K key) throws Exception{
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        throw new Exception("Key: " + key + " not found");
    }

    public void put(K key, V value) throws Exception {
        if(cache.containsKey(key)) {
            throw new Exception("Key: " + key + " already exists");
        }
        cache.put(key, value);
    }
}