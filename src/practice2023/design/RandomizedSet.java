package practice2023.design;

import java.util.*;

public class RandomizedSet {
    private final List<Integer> values;
    private final Map<Integer, Integer> valueToIndex; // to achive O(1) look up time.
    private final Random random;

    public RandomizedSet() {
        values = new ArrayList<>();
        valueToIndex = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (valueToIndex.containsKey(val)) {
            return false;
        }
        int nextIndex = values.size();
        valueToIndex.put(val, nextIndex);
        values.add(nextIndex, val);
        return true;
    }

    public boolean remove(int val) {
        if (!valueToIndex.containsKey(val)) {
            return false;
        }
        int index = values.size();
        int lastElement = values.get(index - 1);
        int idx = valueToIndex.get(val);
        values.set(idx, lastElement);
        // As the last element got moved at the idx.
        valueToIndex.put(lastElement, idx);
        values.remove(index - 1);
        valueToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        int bound = values.size();
        return values.get(random.nextInt(bound));
    }
}