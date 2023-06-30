package practice2023;

import java.util.List;

/**
 * https://leetcode.com/problems/add-two-numbers/
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
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        int carry = 0;
        ListNode sumList = new ListNode();
        ListNode answer = sumList;
        while (l1 != null || l2 != null) {

            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sum = carry + l1Val + l2Val;

            carry = sum / 10;
            ListNode digit = new ListNode();
            digit.val = sum % 10;
            sumList.next = digit;
            sumList = digit;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            ListNode carryNode = new ListNode(carry);
            sumList.next = carryNode;
        }

        // First node will have leading zero which is supposed to be ignored.
        return answer.next;
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
