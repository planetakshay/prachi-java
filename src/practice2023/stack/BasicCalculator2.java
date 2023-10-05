package practice2023.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class BasicCalculator2 {

    public int calculate(String s) {
        if (s == null || s.isBlank()) {
            return 0;
        }
        int num = 0, lastNum = 0;
        char operand = '+';
        int len = s.length();
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == len - 1) {
                if (operand == '+' || operand == '-') {
                    result += lastNum;
                    lastNum = (operand == '+') ? num : -num;
                } else if (operand == '*') {
                    lastNum *= num;
                } else if (operand == '/') {
                    lastNum /= num;
                }
                operand = ch;
                num = 0;
            }
        }
        result += lastNum;
        return result;
    }
}