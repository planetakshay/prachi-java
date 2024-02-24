package practice2023.linkedlist;

/**
 * https://leetcode.com/problems/partition-list/description/
 */
public class PartitionLinkedList {
    public ListNode partition(ListNode head, int x) {

        ListNode smallerHead = new ListNode(0);
        ListNode smaller = smallerHead;
        ListNode greaterHead = new ListNode(0);
        ListNode greater = greaterHead;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                smaller.next = curr;
                smaller = smaller.next;
            } else {
                greater.next = curr;
                greater = greater.next;
            }
            curr = curr.next;
        }
        // Important to set next of greater list to null
        // to avoid cycles.
        greater.next = null;
        smaller.next = greaterHead.next;
        return smallerHead.next;
    }
}