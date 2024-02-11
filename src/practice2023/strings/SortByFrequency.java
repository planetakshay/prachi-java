package practice2023.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 */
public class SortByFrequency {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        Queue<Character> queue = new PriorityQueue<>((c1, c2) -> {
            if (freq.get(c2).equals(freq.get(c1))) {
                return c1.compareTo(c2);
            }
            return freq.get(c2) - freq.get(c1);
        });
        for (char ch : freq.keySet()) {
            queue.offer(ch);
        }
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            for (int i = 0; i < freq.get(ch); i++) {
                builder.append(ch);
            }
        }
        return builder.toString();
    }
}