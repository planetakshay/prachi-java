package practice2023.tree;

import practice2023.ListNode;

/**
 *
 * IK
 * Interview Kickstart problem covered in
 * Tree lectures
 *
 */
public class ConvertLinkedListToTree {
    static TreeNode sortedListToBst(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode middle = findMiddle(head);
        TreeNode root = new TreeNode(middle.val);
        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;
        root.left = sortedListToBst(left);
        root.right = sortedListToBst(right);
        return root;
    }

    static ListNode findMiddle(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow. next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
}
