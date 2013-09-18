package practice.designpatterns;

/**
 * 
 * @author Prachi
 * 
 * @param <K>
 * @param <V>
 * 
 *            Yahoo on-site. Design cache for Catalog, NucleusId and
 *            WalletAccountId. Since the cache objects are different for all
 *            three caches used generics to define any datatype can be used with
 *            this interface. While implementing the interface you can define
 *            what kind of objects the cache will hold.
 * 
 *            1. Design a file system and implement its delete method 2. Design
 *            a Calendar system for the users of organization.
 */
public interface Cache<K, V> {

	public void put(K key, V v);

	public V get(K key);

	public void inValidate();
}
