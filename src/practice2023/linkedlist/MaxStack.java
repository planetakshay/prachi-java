package practice2023.linkedlist;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/max-stack/
 * This is a better implementation compared to the
 * Two TreeSet implementation.
 */
public class MaxStack {
    private final Queue<DoublyLinkedListNode> sortedData;
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;

    public MaxStack() {
        sortedData = new PriorityQueue<>((a, b) -> a.val == b.val ? -1 : b.val - a.val);
        head = new DoublyLinkedListNode();
        tail = new DoublyLinkedListNode();

        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {
        MaxStack /* stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        System.out.println(stack.peek());
        System.out.println(stack.popMax());
        System.out.println(stack.peek());
        System.out.println(stack.peekMax());
        System.out.println(stack.pop());
        System.out.println(stack.peek()); */
                stack = new MaxStack();
        stack.push(5);
        try {
            System.out.println("Peek Max: " + stack.peekMax());
            System.out.println("Pop Max: " + stack.popMax());
        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public void push(int num) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(num);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        sortedData.add(node);
    }

    public int pop() {
        if (tail.prev == head) {
            return -1;
        }
        DoublyLinkedListNode node = tail.prev;
        remove(node);
        sortedData.remove(node);
        return node.val;
    }

    public int peek() throws Exception{
        if (tail.prev == head) {
            throw new Exception("Stack is empty.");
        }
        return tail.prev.val;
    }

    public int peekMax() throws Exception {
        if (sortedData.isEmpty()) {
            throw new Exception("Stack is empty.");
        }
        return sortedData.peek().val;
    }

    public int popMax() throws Exception {
        if (sortedData.isEmpty()) {
            throw new Exception("Stack is empty.");
        }
        DoublyLinkedListNode node = sortedData.poll();
        remove(node);
        return node.val;
    }

    public void remove(DoublyLinkedListNode node) {
        // Remove from linkedList.
        DoublyLinkedListNode next = node.next;
        DoublyLinkedListNode prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }
}

class DoublyLinkedListNode {
    int val;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    public DoublyLinkedListNode(int val) {
        this.val = val;
    }

    public DoublyLinkedListNode() {
    }
}