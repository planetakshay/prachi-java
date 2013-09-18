package practice;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Asked in Yousendit phone screen.
 * 
 * @author Prachi
 * 
 */
public class InMemoryCache {

	private static final Map<String, Object> cache = new ConcurrentHashMap<String, Object>();

	/*
	 * public InMemoryCache() {
	 * 
	 * cache = new ConcurrentHashMap<String, Object>(); }
	 */

	public void put(String key, Object value) {

		if (!cache.containsKey(key)) {

			cache.put(key, value);
		}
	}

	public Object get(String key) {

		return cache.get(key);
	}

	public Map<String, Object> getInstance() {

		return cache;
	}
}
