package practice2023.design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/lfu-cache/description/
 */
public class LFUCacheImpl {
    private final Map<Integer, Integer[]> cache;
    private final Map<Integer, LinkedHashSet<Integer>> freq;
    private int leastFreq;
    private final int capacity;
    public LFUCacheImpl(int capacity) {
        cache = new HashMap<>();
        freq = new HashMap<>();
        leastFreq = 0;
        this.capacity = capacity;
    }
    public static void main(String[] args) {
        LFUCacheImpl lfuCache = new LFUCacheImpl(2);
        lfuCache.put(3, 1);
        lfuCache.put(2, 1);
        lfuCache.put(2, 2);
        lfuCache.put(4, 4);
        System.out.println("Get 2: " + lfuCache.get(2));
    }
    private void insert(int key, int frequency, int value) {
        cache.put(key, new Integer[]{frequency, value});
        freq.putIfAbsent(frequency, new LinkedHashSet<>());
        freq.get(frequency).add(key);
    }
    public int get(int key) {
        Integer[] freqToValue = cache.get(key);
        if (freqToValue == null) {
            return -1;
        }
        int frequency = freqToValue[0];
        Set<Integer> keys = freq.get(frequency);
        keys.remove(key);
        if (keys.isEmpty()) {
            freq.remove(frequency);
            if (leastFreq == frequency) {
                leastFreq++;
            }
        }
        int value = freqToValue[1];
        insert(key, frequency + 1, value);
        System.out.println("key = " + key + " frequency = " + cache.get(key)[0] + ", " + cache.get(key)[1]);
        return value;
    }
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        Integer[] freqToValue = cache.get(key);
        if (freqToValue != null) {
            cache.put(key, new Integer[]{freqToValue[0], value});
            get(key);
            return;
        }
        if (capacity == cache.size()) {
            Set<Integer> keys = freq.get(leastFreq);
            int shouldDelete = keys.iterator().next();
            cache.remove(shouldDelete);
            keys.remove(shouldDelete);
            if (keys.isEmpty()) {
                freq.remove(leastFreq);
            }
        }
        leastFreq = 1;
        insert(key, 1, value);
    }
}