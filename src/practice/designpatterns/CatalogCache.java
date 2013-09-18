package practice.designpatterns;

import java.util.HashMap;
import java.util.Map;

public class CatalogCache implements Cache<String, Catalog> {

	private static Map<String, Catalog> catalogCache = new HashMap<String, Catalog>();

	@Override
	public void put(String key, Catalog v) {
		catalogCache.put(key, v);
	}

	@Override
	public Catalog get(String key) {
		return catalogCache.get(key);
	}

	/**
	 * 
	 * @return
	 * 
	 *         This method is useful to provide a handle to client to access the
	 *         cache object.
	 */
	public static Map<String, Catalog> getInstance() {

		return catalogCache;
	}

	@Override
	public void inValidate() {
		// TODO Auto-generated method stub

	}
}
