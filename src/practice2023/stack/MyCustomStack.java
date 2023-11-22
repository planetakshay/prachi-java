package practice2023.stack;

import java.util.Stack;

public class MyCustomStack implements CustomStack<Integer> {
    Stack<Integer[]> stack;
    public MyCustomStack() {
        stack = new Stack<Integer[]>();
    }
    @Override
    public void push(Integer x) {
        if (stack.isEmpty()) {
            stack.push(new Integer[]{x, x});
            return;
        }
        Integer currMax = stack.peek()[1];
        stack.push(new Integer[]{x, Math.max(x, currMax)});
    }
    public Integer pop() {
        if(stack.isEmpty()) {
            return null;
        }
        return stack.pop()[0];
    }
    public Integer top() {
        if(stack.isEmpty()) {
            return null;
        }
        return stack.peek()[0];
    }
    public Integer peekMax() {
        return stack.peek()[1];
    }
    public Integer popMax() {
        if(stack.isEmpty()) {
            return null;
        }
        Stack<Integer[]> temp = new Stack<>();
        Integer max = stack.peek()[1];
        while(stack.peek()[0] != max) {
            temp.add(stack.pop());
        }
        Integer ans = stack.pop()[1];
        while(!temp.isEmpty()) {
            push(temp.pop()[0]);
        }
        return ans;
    }
}