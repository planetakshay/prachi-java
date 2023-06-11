package practice2023;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * Start with a new node and then look at both sorted list and link
 * the nodes from the input lists to the new node in ascending order.
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // preserve head of the linked list.
        ListNode mergedHead = new ListNode();
        ListNode current = mergedHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
            list1 = list1.next;
        }
        if (list2 != null) {
            current.next = list2;
            list2 = list2.next;
        }
        // Skip first empty/dummy node.
        return mergedHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}