package practice2023.linkedlist;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * Zscaler phone interview.
 * Use l1 = [2,4,3], l2 = [1,9,9,9] to test
 */

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode n1Digit1 = new ListNode(1);
        ListNode n1Digit2 = new ListNode(3);
        ListNode n1Digit3 = new ListNode(8);
        n1Digit2.next = n1Digit3;
        n1Digit1.next = n1Digit2;
        ListNode n2Digit1 = new ListNode(1);
        ListNode n2Digit2 = new ListNode(3);
        ListNode n2Digit3 = new ListNode(2);
        n2Digit2.next = n2Digit3;
        n2Digit1.next = n2Digit2;

        ListNode sumList = addTwoNumbers(n1Digit1, n2Digit1);
        while (sumList != null) {
            System.out.print(sumList.val);
            sumList = sumList.next;
        }
        System.out.println("\nAddition of two numbers without arithmetic operations: " + additionUsingBitManipulation(10, 90));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;

            int sum = carry + a + b;
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
        // First node will have leading zero which is supposed to be ignored.
        return dummy.next;
    }

    public static int additionUsingBitManipulation(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}