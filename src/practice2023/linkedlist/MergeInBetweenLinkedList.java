package practice2023.linkedlist;
/**
 * https://leetcode.com/problems/merge-in-between-linked-lists/
 */
public class MergeInBetweenLinkedList {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode begin = null;
        ListNode stop = list1;
        for (int i = 0; i < b; i++) {
            if (i == a - 1) {
                begin = stop;
            }
            stop = stop.next;
        }
        begin.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = stop.next;
        stop.next = null;
        return list1;
    }
}