package practice2023;

import java.util.*;

public class RemoveDuplicateCharacters {

    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println("String with unique: " + removeDuplicateLetters(s));
    }

    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> lastOccurrence = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!seen.contains(ch)) {
                while (!stack.isEmpty() && ch < stack.peek() && lastOccurrence.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }
                seen.add(ch);
                stack.push(ch);
            }
        }
        // construct the string with unique characters.
        StringBuilder str = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}
