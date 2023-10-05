package practice2023.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Meta mock interview
 *
 */
public class CustomMap {
    Map<String, Integer> map;
    Set<String> keySet;
    Integer commonValue = null;

    public CustomMap() {
        map = new HashMap<>();
        keySet = new HashSet<>();
    }

    /**
     * Time complexity is O(1) as inserts in map and/or set is O(1)
     * @param key
     * @param
     */

    public void put(String key, Integer value) {
        if (commonValue == null) {
            map.put(key, value);
            keySet.add(key);
        } else {
            keySet.add(key);
        }
    }

    /**
     * Time complexity of get is O(1) as contains on a HashSet is O(1) and
     * get on a map is also O(1).
     * @param key
     * @return
     */
    public Integer get(String key) {
        if (keySet.contains(key)) {
            if (map.isEmpty()) {
                return commonValue;
            } else {
                return map.get(key);
            }
        }
        return Integer.MIN_VALUE;
    }

    /**
     * Sets all keys value to value in parameters. The time complexity must be
     * O(1)
     * @param value
     */
    public void putAll(int value) {
        map = new HashMap<>();
        commonValue = value;
    }

    public static void main(String[] args) {
        CustomMap customMap = new CustomMap();
        customMap.put("Prachi", 43);
        customMap.put("Akshay", 43);
        customMap.put("Samarth", 14);
        customMap.put("Vrunda", 8);

        int age = customMap.get("Vrunda");
        age = customMap.get("Samarth");
        age = customMap.get("keydoesnexist");

        customMap.putAll(100);
        customMap.get("keydoesnexist");
        customMap.put("god", 150);
        age = customMap.get("GOD"); // Key matching is case-sensitive.
        customMap.get("keydoesnexist");

        System.out.println("Test finished");
    }
}