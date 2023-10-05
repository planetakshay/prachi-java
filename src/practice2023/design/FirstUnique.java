package practice2023.design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class FirstUnique {
    Set<Integer> queue;
    Map<Integer, Boolean> unique = new HashMap<>();

    public FirstUnique(int[] nums) {
        queue = new LinkedHashSet<>();
        unique = new HashMap<>();
        for(int num : nums) {
            this.add(num);
        }
    }
    public int showFirstUnique() {
        if(!queue.isEmpty()) {
            return queue.iterator().next();
        }
        return -1;
    }
    public void add(int value) {
        if(unique.containsKey(value)) {
            unique.put(value, false);
            queue.remove(value);
        } else {
            unique.put(value, true);
            queue.add(value);
        }
    }
}