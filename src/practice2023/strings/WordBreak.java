package practice2023.strings;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> dictionary = new LinkedList<>(Arrays.asList("leet","code"));
        System.out.println("wordbreak: " + wordBreak(s, dictionary));

        s = "applepenapple";
        dictionary = new LinkedList<>(Arrays.asList("apple","pen"));
        System.out.println("wordbreak: " + wordBreak(s, dictionary));

        s = "catsandog";
        dictionary = new LinkedList<>(Arrays.asList("cats","dog","sand","and","cat"));
        System.out.println("wordbreak: " + wordBreak(s, dictionary));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        // Convert dictionary into set so that we can get O(1) for
        // contains operation.
        Set<String> words = new HashSet<>(wordDict);
        // Use a queue to insert indices of array.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int len = s.length();
        // Keep a record of which index has been explored already.
        boolean[] seen = new boolean[len+1];

        while(!queue.isEmpty()) {
            int start = queue.poll();
            if(start == len) {
                return true;
            }
            for(int end = start + 1; end <= len; end++) {
                if(seen[end]) {
                    continue;
                }
                if(words.contains(s.substring(start,end))) {
                    queue.add(end);
                    seen[end] = true;
                }
            }
        }
        return false;
    }
}