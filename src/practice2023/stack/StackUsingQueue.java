package practice2023.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class StackUsingQueue {
    Queue<Integer> q1;
    public StackUsingQueue() {
        q1 = new LinkedList<>();
    }
    public void push(int x) {
        q1.add(x);
        for (int i = 1; i < q1.size(); i++) {
            q1.add(q1.remove());
        }
    }
    public int pop() {
        return q1.remove();
    }
    public int top() {
        return q1.peek();
    }
    public boolean empty() {
        return q1.isEmpty();
    }
}