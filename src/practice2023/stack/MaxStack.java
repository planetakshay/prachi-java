package practice2023.stack;

import java.util.Stack;

public class MaxStack {
    Stack<int[]> stack;

    public MaxStack() {
        stack = new Stack<>();
    }
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
            return;
        }
        int currMax = stack.peek()[1];
        stack.push(new int[]{x, Math.max(x, currMax)});
    }
    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.pop()[0];
    }
    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek()[0];
    }
    public int peekMax() {
        return stack.peek()[1];
    }
    public int popMax() {
        if (stack.isEmpty()) {
            return -1;
        }
        Stack<int[]> temp = new Stack<>();
        int max = stack.peek()[1];
        while (stack.peek()[0] != max) {
            temp.add(stack.pop());
        }
        int ans = stack.pop()[1];
        while (!temp.isEmpty()) {
            push(temp.pop()[0]);
        }
        return ans;
    }
}