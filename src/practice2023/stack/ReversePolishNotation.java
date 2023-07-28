package practice2023.stack;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = new String[] {"2","1","+","3","*"};
        System.out.println("Computed equation: " + evalRPN(tokens));

        tokens = new String[] {"4","13","5","/","+"};
        System.out.println("Computed equation: " + evalRPN(tokens));

        tokens = new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Computed equation: " + evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {

        int ans = 0;
        if (tokens == null || tokens.length == 0) {
            return ans;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    final int b = stack.pop();
                    final int a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        if (stack.size() == 1) {
            ans = stack.pop();
        }
        return ans;
    }
}
