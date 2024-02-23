package interviewquestion;

/**
 * ZScaler phone interview
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
 * and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *  
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * <p>
 * <p>
 * Output: [7,0,8]
 * <p>
 * Explanation: 342 + 465 = 807.
 * <p>
 * <p>
 * l1 = [2,4,3], l2 = [1,9,9,9]
 * 3 3 3 1 0
 * <p>
 * 1 1 1
 * 1 1 1 1
 * <p>
 * how thread local data is shared in Spring between threads.
 * Optimistic lock and pessimistic lock in hibernate.
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        l11.next = l12;
        l1.next = l11;

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        l22.next = l23;
        l21.next = l22;
        l2.next = l21;

        Solution solution = new Solution();
        ListNode ans = solution.addition(l1, l2);
        while (ans != null) {
            System.out.print("\t" + ans.value);
            ans = ans.next;
        }
    }

    public ListNode addition(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 != null ? l1.value : 0;
            int v2 = l2 != null ? l2.value : 0;
            int sum = carry + v1 + v2;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}
