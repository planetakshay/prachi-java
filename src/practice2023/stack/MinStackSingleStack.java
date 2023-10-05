package practice2023.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/description/
 * Since the requirement of the problem is to retrieve minimum element
 * in constant time.
 */
public class MinStackSingleStack {
    public static void main(String[] args) {
        MinStackSingleStack minStack = new MinStackSingleStack();

        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);

        minStack.pop();
        System.out.print("\t" + minStack.getMin());
        minStack.pop();
        System.out.print("\t" + minStack.getMin());
        minStack.pop();
        System.out.print("\t" + minStack.getMin() + "\n");
    }
    Stack<int[]> stack;

    public MinStackSingleStack() {
        stack = new Stack<>();
    }

    public int size() {
        if(stack.isEmpty()) {
            return 0;
        }
        return stack.size();
    }

    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.peek()[0];
    }

    public int getMin() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.peek()[1];
    }

    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        stack.pop();
    }

    public void push(int value) {
        if (stack.isEmpty()) {
            stack.push(new int[]{value, value});
            return;
        }
        int currMin = stack.peek()[1];
        stack.push(new int[]{value, Math.min(value, currMin)});
    }
}
