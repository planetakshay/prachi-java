package practice2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println("Str=" + countAndSay(5));

        /* int[][] pairs = countAndSayLeetCode(3322251);
        System.out.println("pairs: " + Arrays.deepToString(pairs)); */
    }

    public static String countAndSay(int n) {
        String str = "1";
        for(int i = 1; i < n; i++) {
            str = countAndSay(str);
        }
        return str;
    }

    public static String countAndSay(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        int count = 1;
        char curr = s.charAt(0);
        StringBuilder builder = new StringBuilder();
        for(int i = 1;i<s.length();i++) {
            if(curr == s.charAt(i)) {
                count++;
            } else {
                builder.append(count);
                builder.append(curr);
                curr = s.charAt(i);
                count = 1;
            }
        }
        builder.append(curr);
        builder.append(count);
        return builder.toString();
    }

    /* public static String countAndSay(String n) {

        Map<Character, Integer> pairs = new LinkedHashMap<>();
        for(int i = 0; i < n.length();i++) {
            char curr = n.charAt(i);
            pairs.put(curr, pairs.getOrDefault(curr, 0) + 1);
        }

        StringBuilder strBuilder = new StringBuilder();
        for(Map.Entry pair : pairs.entrySet()) {
            strBuilder.append(pair.getValue());
            strBuilder.append(pair.getKey());
        }
        return strBuilder.toString();
    }

    public static String buildSayString(Map<Character, Integer> pairs) {
        StringBuilder strBuilder = new StringBuilder();
        for(Map.Entry pair : pairs.entrySet()) {
            strBuilder.append(pair.getValue());
            strBuilder.append(pair.getKey());
        }
        return strBuilder.toString();
    }

    public static int[][] countAndSayLeetCode(int n) {
        String str = String.valueOf(n);
        int len = str.length();
        int[][] pairs = new int[len][2];
        if(len == 1) {
            pairs[0][0] = (char) n;
            pairs[0][1] = 1;
            return pairs;
        }
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for(int i = 0; i < len;i++) {
            char curr = str.charAt(i);
            freq.put(curr, freq.getOrDefault(curr, 0) + 1);
        }
        pairs = new int[freq.size()][2];
        int i = 0;
        for(Map.Entry fr : freq.entrySet()) {
            pairs[i][0] = (int) fr.getValue();
            pairs[i][1] = Character.getNumericValue((char)fr.getKey());
            i++;
        }
        return pairs;
    }

    public static String concatenate(int[][] pairs) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < pairs.length;i++) {
            builder.append(pairs[i][0]);
            builder.append(pairs[i][1]);
        }
        return builder.toString();
    } */
}