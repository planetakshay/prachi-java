package algo;

import java.util.Stack;

public class Balance {
    public static void main(String[] args) {
        String input = "[{()}]";
        System.out.println("Is balanced: " + check(input));

        input = "((((()))";
        System.out.println("Is balanced: " + check(input));

        input = "no brackets";
        System.out.println("Is balanced: " + check(input));

        input = "]";
        System.out.println("Is balanced: " + check(input));
    }

    private static boolean check(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (char ch : array) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (ch == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}