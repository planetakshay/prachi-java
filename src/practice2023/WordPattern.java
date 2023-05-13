package practice2023;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/word-pattern/description/

public class WordPattern {

    public static void main(String[] args) {
        System.out.println(wordPattern("abab", "dog cat dog cat"));
    }

    public static boolean wordPattern(String pattern, String s) {
        if(pattern == null || pattern.length() < 1 || s == null || s.length() < 1) {
            return false;
        }
        String[] words = s.split(" ");

        if(pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> patternMap = new HashMap<>();
        for(int i=0;i<pattern.length();i++) {
            if(!patternMap.containsValue(words[i])) {
                patternMap.put(pattern.charAt(i), words[i]);
            }
        }
        // compare the order.

        for(int i=0;i<pattern.length();i++) {
            if(!words[i].equalsIgnoreCase(patternMap.get(pattern.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
