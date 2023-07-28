package practice2023.stack;

import java.util.*;

public class DecodeString {
    public static void main(String[] args) {
        String str = "3[a]2[bc]";
        System.out.println("Decoded : " + decode(str));

        str = "3[a2[c]]";
        System.out.println("Decoded : " + decode(str));

        str = "2[abc]3[cd]ef";
        System.out.println("Decoded : " + decode(str));

        str = "100[leetcode]";
        System.out.println("Decoded : " + decode(str));
    }

    public static String decode(String encoded) {
        Stack<Character> stack = new Stack<>();
        for (char ch : encoded.toCharArray()) {
            if (ch != ']') {
                stack.push(ch);
            } else {
                StringBuilder str = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    str.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                }
                StringBuilder numStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    numStr.append(stack.pop());
                }
                int limit =  Integer.parseInt(numStr.reverse().toString());
                for (int i = 1; i <= limit; i++) {
                    int k = str.length() - 1;
                    while (k >= 0) {
                        stack.push(str.charAt(k--));
                    }
                }
            }
        }
        char[] builder = new char[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            builder[index] = stack.pop();
            index--;
        }
        return new String(builder);
    }
}