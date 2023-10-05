package practice2023.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/description/
 * Since the requirement of the problem is to retrieve maximum element
 * in constant time.
 */
public class MaxStackSingleStack {
    public static void main(String[] args) {
        MaxStackSingleStack maxStack = new MaxStackSingleStack();

        maxStack.push(512);
        maxStack.push(-1024);
        maxStack.push(-1024);
        maxStack.push(512);

        maxStack.pop();
        System.out.print("\t" + maxStack.getMax());
        maxStack.pop();
        System.out.print("\t" + maxStack.getMax());
        maxStack.pop();
        System.out.print("\t" + maxStack.getMax() + "\n");
    }
    Stack<int[]> stack;

    public MaxStackSingleStack() {
        stack = new Stack<>();
    }
    public void push(int value) {
        if (stack.isEmpty()) {
            stack.push(new int[]{value, value});
            return;
        }
        int currMax = stack.peek()[1];
        stack.push(new int[]{value, Math.max(value, currMax)});
    }
    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        stack.pop();
    }
    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.peek()[0];
    }

    public int size() {
        if(stack.isEmpty()) {
            return 0;
        }
        return stack.size();
    }

    public int getMax() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.peek()[1];
    }
}
