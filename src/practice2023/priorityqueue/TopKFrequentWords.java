package practice2023.priorityqueue;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 */
public class TopKFrequentWords {
    public static void main(String[] args){
        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        int k = 2;
        System.out.println("Top  frequent words: " + topKFrequent(words, k));
    }
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        Queue<String> topK = new PriorityQueue<>((st1, st2) -> {
            if (freq.get(st1).equals(freq.get(st2))) {
                return st1.compareTo(st2);
            }
            return freq.get(st2) - freq.get(st1);
        });
        topK.addAll(freq.keySet());

        int count = k;
        List<String> topKWords = new LinkedList<>();

        while (count > 0 && !topK.isEmpty()) {
            topKWords.add(topK.poll());
            count--;
        }
        return topKWords;
    }
}