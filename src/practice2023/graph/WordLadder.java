package practice2023.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/solution/
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int beginL = beginWord.length();
        Map<String, List<String>> allCombinations = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < beginL; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, beginL);
                List<String> tran = allCombinations.getOrDefault(newWord, new ArrayList<>());
                tran.add(word);
                allCombinations.put(newWord, tran);
            }
        });

        Queue<WordLevel> queue = new LinkedList<>();
        queue.offer(new WordLevel(beginWord, 1));
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            WordLevel pair = queue.poll();
            String word = pair.str;
            int num = pair.num;
            for (int i = 0; i < beginL; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, beginL);
                for (String nei : allCombinations.getOrDefault(newWord, new ArrayList<>())) {
                    if (nei.equals(endWord)) {
                        return num + 1;
                    }
                    if (!visited.containsKey(nei)) {
                        visited.put(nei, true);
                        queue.offer(new WordLevel(nei, num + 1));
                    }
                }
            }
        }
        return 0;
    }
}

class WordLevel {
    String str;
    Integer num;

    public WordLevel(String str, Integer num) {
        this.str = str;
        this.num = num;
    }
}