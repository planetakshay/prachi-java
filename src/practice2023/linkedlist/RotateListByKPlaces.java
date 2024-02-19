package practice2023.linkedlist;

public class RotateListByKPlaces {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // have tail point to the head.
        ListNode curr = head;
        int n = 1;
        while (curr.next != null) {
            curr = curr.next;
            n++;
        }
        curr.next = head;

        // break the link at the n - k place and
        // set the new tail.
        // return new head. (i.e next of tail)

        ListNode tail = head;
        int parts = k % n;
        for (int i = 0; i < n - parts -1; i++) {
            tail = tail.next;
        }
        ListNode newHead = tail.next;
        tail.next = null;
        return newHead;
    }
}
