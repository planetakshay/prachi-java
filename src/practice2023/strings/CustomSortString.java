package practice2023.strings;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * https://leetcode.com/problems/custom-sort-string/
 */
public class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Character, Integer> freq = new ConcurrentHashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        StringBuilder builder = new StringBuilder();
        for (char ch : order.toCharArray()) {
            int count = freq.getOrDefault(ch, 0);
            while (count > 0) {
                builder.append(ch);
                count--;
            }
            freq.remove(ch);
        }
        for (char ch : freq.keySet()) {
            int count = freq.getOrDefault(ch, 0);
            while (count > 0) {
                builder.append(ch);
                count--;
            }
            freq.remove(ch);
        }
        return builder.toString();
    }
}