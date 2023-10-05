package practice2023.strings;

import java.util.*;

public class UncommonWords {

    public static void main(String[] args) {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        System.out.println(Arrays.toString(uncommonFromSentences(s1, s2)));
    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        String[] words = s1.split(" ");
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        words = s2.split(" ");
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        List<String> unique = new ArrayList();
        for (String key : wordFrequency.keySet()) {
            if (wordFrequency.get(key) == 1) {
                unique.add(key);
            }
        }
        return unique.toArray(new String[unique.size()]);
    }
}