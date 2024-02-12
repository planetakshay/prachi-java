package practice2023.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || s.isBlank() || t == null || t.isBlank()) {
            return "";
        }
        int sLen = s.length();
        int tLen = t.length();
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < tLen; i++) {
            char ch = t.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int size = freq.size();
        int start = 0, end = 0;
        int ready = 0;

        Map<Character, Integer> freqWithinWindow = new HashMap<>();
        int[] ans = {-1, 0, 0};

        while (end < sLen) {
            char ch = s.charAt(end);
            freqWithinWindow.put(ch, freqWithinWindow.getOrDefault(ch, 0) + 1);

            if (freq.containsKey(ch) &&
                    freqWithinWindow.get(ch).intValue() == freq.get(ch).intValue()) {
                ready++;
            }

            while (start <= end && ready == size) {
                ch = s.charAt(start);
                int curr = end - start + 1;
                if (ans[0] == -1 || curr < ans[0]) {
                    ans[0] = curr;
                    ans[1] = start;
                    ans[2] = end;
                }

                freqWithinWindow.put(ch, freqWithinWindow.get(ch) - 1);
                if (freq.containsKey(ch) &&
                        freqWithinWindow.get(ch).intValue() < freq.get(ch).intValue()) {
                    ready--;
                }
                start++;
            }
            end++;
        }
        if (ans[0] == -1) {
            return "";
        }
        return s.substring(ans[1], ans[2] + 1);
    }
}