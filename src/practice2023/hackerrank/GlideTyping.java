package practice2023.hackerrank;

import java.util.*;

/**
 * Salesforce phone screen.
 */
public class GlideTyping {
    TreeSet<String> possible;
    List<String> dictionary;
    String first = "";
    public static void main(String[] args) {
        GlideTyping glideTyping = new GlideTyping();
        String ans = glideTyping.formWords("something");
        System.out.println("Ans: " + ans);
        System.out.println("First: " + glideTyping.first);

        ans = glideTyping.formWords("nothing");
        System.out.println("Ans: " + ans);
        System.out.println("First: " + glideTyping.first);

        ans = glideTyping.formWords("fivefour");
        System.out.println("Ans: " + ans);
        System.out.println("First: " + glideTyping.first);
    }
    public String formWords(String input) {
        possible = new TreeSet<>();
        dictionary = new LinkedList<>();
        dictionary.add("one");
        dictionary.add("two");
        dictionary.add("three");
        dictionary.add("four");
        dictionary.add("five");
        findWord(input);
        if(possible.isEmpty()) {
            return "-1";
        }
        return possible.first();
    }
    public void findWord(String str) {
        for (int i = 0; i < dictionary.size(); i++) {
            matchWord(dictionary.get(i), str);
        }
    }
    public void matchWord(String str, String s) {
        for (int i = 0; i < str.length(); i++) {
            if (s.indexOf(str.charAt(i)) < 0) {
                return;
            }
        }
        if(first.isEmpty() || first.compareTo(str) > 0) {
            first = str;
        }
        possible.add(str);
    }
}