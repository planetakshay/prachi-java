package practice2023.design;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    Map<Integer, Integer> frequency;
    public TwoSum() {
        frequency = new HashMap<>();
    }
    public void add(int number) {
        frequency.put(number, frequency.getOrDefault(number, 0) + 1);
    }
    public boolean find(int value) {
        for (Map.Entry entry : frequency.entrySet()) {
            Integer key = (Integer) entry.getKey();
            Integer val = (Integer) entry.getValue();
            int comp = value - key;
            if (comp != key.intValue()) {
                if (frequency.containsKey(comp)) {
                    return true;
                }
            } else {
                if (val.intValue() > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}