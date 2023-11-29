package practice2023.linkedlist;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyLinkedWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        // curr has moved. point to head.
        curr = head;
        while (curr != null) {
            curr.next.random = (curr.random != null) ? curr.random.next : null;
            curr = curr.next.next;
        }
        Node original = head;
        Node copied = head.next;
        Node originalNext = head.next;
        while (original != null) {
            original.next = original.next.next;
            copied.next = copied.next != null ? copied.next.next : null;
            original = original.next;
            copied = copied.next;
        }
        return originalNext;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}