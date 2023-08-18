package practice2023.strings;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break-ii/description/
 */
public class WordBreakII {

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        wordBreak(s, dict).stream().forEach(System.out::println);
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> sentences = new HashMap<>();
        return wordBreak(s, wordDict, sentences);
    }

    private static List<String> wordBreak(final String s, List<String> dict,
                                          Map<String, List<String>> sentences) {
        if (sentences.containsKey(s)) {
            return sentences.get(s);
        }
        List<String> sentence = new ArrayList<>();
        for (int i = 1; i < s.length(); ++i) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if (dict.contains(prefix)) {
                for (String word : wordBreak(suffix, dict, sentences)) {
                    sentence.add(prefix + " " + word);
                }
            }
        }
        if (dict.contains(s)) {
            sentence.add(s);
        }
        sentences.put(s, sentence);
        return sentence;
    }
}
