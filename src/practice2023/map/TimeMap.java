package practice2023.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/time-based-key-value-store/
 */
public class TimeMap {
    Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<String, TreeMap<Integer, String>>();
    }

    public void set(String key, String value, int timestamp) {
        Map<Integer, String> timedValue = timeMap.get(key);
        if (timedValue == null) {
            timedValue = new TreeMap<>();
        }
        timedValue.put(timestamp, value);
        timeMap.put(key, (TreeMap<Integer, String>) timedValue);
    }

    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) {
            return "";
        }
        // User floorKey of the timestamp because floorKey will return
        // greatest key below timestamp.
        Integer floorKey = timeMap.get(key).floorKey(timestamp);
        String value =  "";
        if(floorKey != null) {
            value = timeMap.get(key).get(floorKey);
        }
        return value;
    }
}