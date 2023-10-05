package practice2023.stack;

import javax.print.attribute.IntegerSyntax;
import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println("Evaluation: " + calculate(s));
    }
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        int result = 0;
        int sign = 1;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                operand = 10 * operand + (int) (ch - '0');
            } else if (ch == '+') {
                result += sign * operand;
                sign = 1;
                operand = 0;
            } else if (ch == '-') {
                result += sign * operand;
                sign = -1;
                operand = 0;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (ch == ')') {
                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;
            }
        }
        return result + (sign * operand);
    }
}
