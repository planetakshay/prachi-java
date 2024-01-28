package practice2023.linkedlist;

/**
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 * <p>
 * Leetcode Top 75 Interview questions.
 * <p>
 * First reverse the second half of the linked list.
 * Now start with first node in the first half
 * and its twin which is first node in the reversed second half.
 * Start summing the values of twins while maintaining the max so far.
 */
public class MaxTwinSum {
    public int pairSum(ListNode head) {
        // Find middle node of the linkedList.
        ListNode slow = findMid(head);

        // Reverse the second half of the linkedList.
        // First points to the first node of reversed second half.
        ListNode first = reverse(slow);

        // Compute twin sum and find max twin sum.
        ListNode start = head;
        int max = 0;
        while (first != null) {
            int sum = start.val + first.val;
            max = Math.max(max, sum);
            first = first.next;
            start = start.next;
        }
        return max;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode slow) {
        ListNode next, prev = null;
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        return prev;
    }
}