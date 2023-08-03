package practice2023.tree.trie;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/camelcase-matching/description/
 */
public class PatternMatching {

    public static void main(String[] args) {
        String[] queries = new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FB";
        List<Boolean> ans = camelMatch(queries, pattern);
        System.out.println(Arrays.toString(ans.toArray()));
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new LinkedList<>();
        if (queries == null || queries.length == 0 || pattern == null || pattern.isBlank()) {
            ans.add(false);
        }
        for (String query : queries) {
            ans.add(matchPattern(query, pattern));
        }
        return ans;
    }

    public static boolean matchPattern(String query, String pattern) {
        int index = 0;
        for(char ch : query.toCharArray()) {
            if (index < pattern.length() && ch == pattern.charAt(index)) {
                index++;
            } else if (Character.isUpperCase(ch)) {
                return false;
            }
        }
        return index == pattern.length();
    }
}