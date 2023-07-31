package practice2023.strings;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=top-interview-150
 */
public class ReverseStringByWords {

    public static void main(String[] args) {
        System.out.println("Reversed: " + reverseWords("a good   example"));
        System.out.println("Reversed: " + reverseWordsStack("a good   example"));
    }

    public static String reverseWords(String s) {
        String altered = s.trim();
        String[] splits = altered.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i = splits.length - 1; i>=0; i--) {
            if(splits[i].isEmpty()) {
                continue;
            } else {
                builder.append(splits[i]);
                builder.append(" ");
            }
        }
        return builder.toString().trim();
    }

    public static String reverseWordsStack(String s) {
        String altered = s.trim();
        Stack<String> stack = new Stack<>();
        String word = "";
        for(int i = 0; i<altered.length();i++) {
            char ch = altered.charAt(i);
            if(ch == 32) {
                if(!word.isBlank()) {
                    stack.push(word);
                    word = "";
                }
            } else {
                word = word + ch;
            }
        }
        if(!word.isBlank()) {
            stack.push(word);
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()) {
            builder.append(stack.pop()).append(" ");
        }
        return builder.toString().trim();
    }
    public static String reverseWordsOldSchool(String s) {
        String altered = s.trim();

        for(int i=0;i<altered.length(); i++) {

        }
        return null;
    }

}
