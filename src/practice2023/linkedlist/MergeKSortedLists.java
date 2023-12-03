package practice2023.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * Included in Blind 75 questions.
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
               return o1.val - o2.val;
            }
        };
        Queue<ListNode> q = new PriorityQueue<>(comparator);
        for(ListNode list : lists) {
            if(list != null) {
                q.add(list);
            }
        }

        // Use a dummy node and set the value to zero.
        // Now use a temporary node and let it point to head.

        ListNode head = new ListNode(0);
        ListNode point = head;

        // Initially point will have value 0. Then pop first list
        // from the queue and set point's next to this recently popped
        // list. Now move point to first element of the first list.
        // and add all the AtlassianRest of the nodes back to the queue.
        // This way all the first elements of the lists will come together
        // then second, third .... nth.

        while(!q.isEmpty()) {
            point.next = q.poll();
            point = point.next;
            ListNode next = point.next;
            if(next != null) {
                q.add(next);
            }
        }

        // After all the elements are merged in a single list
        // the head will still point to initial value of 0.
        // head.next will point to the merged list.
        // return head.next.

        return head.next;
    }

    public ListNode mergeKListsDivideAndConquer(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        int len = lists.length - 1;
        while(len > 0) {
            int i = 0, j = len;
            while(i < j) {
                lists[i] = merge(lists[i], lists[j]);
                i++;
                j--;
                if(i >= j) {
                    len = j;
                }
            }
        }
        return lists[0];
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode result = null;
        if(a == null) {
            return b;
        } else if(b == null) {
            return a;
        }
        if(a.val <= b.val) {
            result = a;
            result.next = merge(a.next, b);
        } else {
            result = b;
            result.next = merge(a, b.next);
        }
        return result;
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