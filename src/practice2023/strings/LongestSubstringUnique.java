package practice2023.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringUnique {
    public static void main(String[] args) {
        System.out.println("longestSubstrWithUniqueChars: " + longestSubstrWithUniqueChars("CODINGISHORRIBLE"));
    }

    public static int longestSubstrWithUniqueChars(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<Character> unique = new HashSet<>();
        int i = 0, j = 0, max = 0;
        while(j < s.length()) {
            if(!unique.contains(s.charAt(j))) {
                unique.add(s.charAt(j));
                j++;
                max = Math.max(unique.size(), max);
            } else {
                unique.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
