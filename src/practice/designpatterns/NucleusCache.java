package practice.designpatterns;

import java.util.HashMap;
import java.util.Map;

public class NucleusCache implements Cache<String, String> {

	private static Map<String, String> nucleusCache = new HashMap<String, String>();

	@Override
	public void put(String key, String v) {
		nucleusCache.put(key, v);
	}

	@Override
	public String get(String key) {
		return nucleusCache.get(key);
	}

	@Override
	public void inValidate() {

	}

	/**
	 * 
	 * @return
	 * 
	 *         This method is useful to provide a handle to client to access the
	 *         cache object.
	 */
	public static Map<String, String> getInstance() {

		return nucleusCache;
	}
}
