package practice2023.queue;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueUsingStack() {
        s1 = new Stack();
        s2 = new Stack();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        int num = peek();
        s2.pop();
        return num;
    }

    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}