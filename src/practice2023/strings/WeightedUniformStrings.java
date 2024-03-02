package practice2023.strings;

import java.util.*;

/**
 * hacker rank challenge.
 */
public class WeightedUniformStrings {

    public static void main(String[] args) {
        String s = "abccddde";
        List<Integer> queries = List.of(6, 1, 3, 12, 5, 9, 10);
        System.out.println(weightedUniformStrings(s, queries));

        s = "aaabbbbcccddd";
        queries = List.of(5, 9, 7, 8, 12, 5);
        System.out.println(weightedUniformStrings(s, queries));
    }

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        int len = s.length();
        Map<String, Integer> uniformStringToWeight = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        int weight = (s.charAt(0) - 'a') + 1;
        builder.append(s.charAt(0));
        uniformStringToWeight.put(builder.toString(), weight);

        for (int i = 1; i < len; i++) {
            char prev = builder.charAt(builder.length() - 1);
            char ch = s.charAt(i);
            weight = (ch - 'a') + 1;
            if (ch != prev) {
                builder.setLength(0);
            }
            builder.append(s.charAt(i));
            uniformStringToWeight.put(builder.toString(), weight * builder.length());
        }
        Set<Integer> weights = new HashSet<>(uniformStringToWeight.values());
        for (int query : queries) {
            if (weights.contains(query)) {
                ans.add("Yes");
            } else {
                ans.add("No");
            }
        }
        return ans;
    }
}