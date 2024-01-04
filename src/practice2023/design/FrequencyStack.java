package practice2023.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-frequency-stack/
 */
public class FrequencyStack {
    Map<Integer, Integer> map;
    Map<Integer, Stack<Integer>> byFrequency;
    int max;

    public FrequencyStack() {
        map = new HashMap<>();
        byFrequency = new HashMap<>();
        max = 0;
    }

    public void push(int val) {
        int curr = map.getOrDefault(val, 0) + 1;
        map.put(val, curr);
        if(curr > max) {
            max = curr;
        }
        byFrequency.computeIfAbsent(curr, stack -> new Stack()).push(val);
    }

    public int pop() {
        int val = byFrequency.get(max).pop();
        map.put(val, map.get(val) - 1);
        if(byFrequency.get(max).size() == 0) {
            max--;
        }
        return val;
    }
}