package practice;

import java.util.Stack;

class List {

    int data;
    List next;

    public List(int data) {

        this.data = data;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + data;
        result = prime * result + ((next == null) ? 0 : next.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        List other = (List) obj;
        if (data != other.data)
            return false;
        if (next == null) {
            if (other.next != null)
                return false;
        } else if (!next.equals(other.next))
            return false;
        return true;
    }

}

public class SinglyLinkedListOps {

    public List addNodeBack(List head, int data) {

        List node = new List(data);

        if (head == null) {

            head = node;

            return head;
        }

        List curr = head;

        while (curr.next != null) {

            curr = curr.next;
        }

        curr.next = node;

        return head;
    }

    public List removeNode(List head, int data) {

        if (head == null) {

            return null;
        }

        List curr = head;

        List prev = null;

        while (curr != null) {

            if (curr.data == data) {

                curr = curr.next;

                if (prev == null) {

                    prev = curr;

                } else {

                    prev.next = curr;
                }

            } else {

                prev = curr;

                curr = curr.next;
            }

        }

        return head;
    }

    public List reverse(List head) {

        List prev = null;
        List curr = head;
        List next = null;

        while (curr != null) {

            next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }

        return prev;
    }

    private int lengthOfLinkedList(List node) {
        int length = 0;
        while (node != null) {
            ++length;
            node = node.next;
        }
        return length;
    }

    public List reverseByGivenSize(List head, int limit) {
        if (head == null || head.next == null) return head;

        int length = lengthOfLinkedList(head);

        List dummyHead = new List(0);
        dummyHead.next = head;

        List pre = dummyHead;
        List cur;
        List nex;

        while (length >= limit) {
            cur = pre.next;
            nex = cur.next;
            for (int i = 1; i < limit; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            length -= limit;
        }
        return dummyHead.next;
    }

    public List reverseByGivenSizeOriginal(List head, int limit) {

        if (head == null || head.next == null || limit == 1) {
            return head;
        }

        List prev = null;
        List curr = head;
        List next = null;

        int count = 0;

        while (curr != null && count < limit) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (next != null) {
            head.next = reverseByGivenSize(next, limit);
        }

        return prev;
    }

    public void print(List head) {

        List node = head;

        while (node != null) {

            System.out.print(node.data);

            if (node.next != null) {

                System.out.print("-->");
            }

            node = node.next;
        }
        System.out.println("\n");
    }

    public static void main(String args[]) {

        List head = null;

        SinglyLinkedListOps opsObj = new SinglyLinkedListOps();

        head = opsObj.addNodeBack(head, 2);

        head = opsObj.addNodeBack(head, 4);

        head = opsObj.addNodeBack(head, 8);

        head = opsObj.addNodeBack(head, 16);

        head = opsObj.addNodeBack(head, 32);

        head = opsObj.addNodeBack(head, 64);

        head = opsObj.addNodeBack(head, 128);

        head = opsObj.addNodeBack(head, 256);

        head = opsObj.addNodeBack(head, 512);

        head = opsObj.addNodeBack(head, 1024);

        head = opsObj.addNodeBack(head, 2048);

        System.out.println("Original LinkedList: ");
        opsObj.print(head);

		System.out.println("Remove Node: ");
        head = opsObj.removeNode(head, 16);
        opsObj.print(head);

        System.out.println("Does Linked List has loop? " + (opsObj.hasLoop(head) ? "Yes" : "No"));

        List nThNode = opsObj.nThFromLast(head, 2);
        System.out.println("Nth Node from end is: " + nThNode.data);

        List nThNodeFromBeginning = opsObj.nThFromBeginning(head, 6);
        System.out.println("Nth Node from the beginning is: "
                + nThNodeFromBeginning.data);
        // head = opsObj.reverse(head);
        opsObj.print(head);

        System.out.println("Reverse in the groups of k nodes: ");
        head = opsObj.reverseByGivenSize(head, 4);
        opsObj.print(head);

		System.out.println("Swap Kth Node: ");
        head = opsObj.swapKthNode(head, 3);
        opsObj.print(head);
    }

    /**
     * Returns true if a linked list has a loop. False otherwise. If you want to
     * return the node where the loop forms then return the node instead of the
     * boolean values.
     *
     * @param first
     * @return
     */
    boolean hasLoop(List first) {

        if (first == null) // list does not exist..so no loop either.
            return false;

        List slow, fast; // create two references.

        slow = fast = first; // make both refer to the start of the list.

        while (true) {

            slow = slow.next; // 1 hop.

            if (fast.next != null)
                fast = fast.next.next; // 2 hops.
            else
                return false; // next node null => no loop.

            if (slow == null || fast == null) // if either hits null..no loop.
                return false;

            if (slow == fast) // if the two ever meet...we must have a loop.
                return true;
        }
    }

    public List nThFromLast(List head, int n) {

        if (head != null) {

            List temp = head;
            List node = head;

            for (int index = 0; index < n - 1; index++) {

                if (temp == null) {

                    return null;
                }
                temp = temp.next;

            }

            if (temp == null) {

                return null;
            }

            while (temp.next != null) {

                node = node.next;
                temp = temp.next;
            }

            return node;

        }
        return null;
    }

    public List nThFromBeginning(List head, int n) {

        int count = 1;

        List pointer = head;

        while (count < n) {

            if (pointer == null) {

                return null;
            }
            pointer = pointer.next;

            count++;
        }

        return pointer;
    }

    /**
     * Swap Kth node from beginning of the singly linked list with the Kth node
     * from the end of the singly linked list.
     *
     * @param head
     * @param k
     * @return
     */

    public List swapKthNode(List head, int k) {

        if (head == null) {

            return null;
        }

        List kthFromStart = head;
        List kthFromEnd = head;

        int count = 1;

        while (count < k) {

            if (kthFromStart == null) {

                return null;
            }
            kthFromStart = kthFromStart.next;
            count++;
        }

        List temp = kthFromStart;

        while (temp != null) {

            temp = temp.next;
            kthFromEnd = kthFromEnd.next;
        }

        if (kthFromStart != null && kthFromEnd != null) {

            int buffer = kthFromStart.data;
            kthFromStart.data = kthFromEnd.data;
            kthFromEnd.data = buffer;
        }

        return head;
    }

    /**
     * @param l1
     * @param l2
     * @return Returns if there is a common node between two LinkedLists. The
     * current approach is to push both the linked list's node to two
     * separate stacks and then pop them out and compare both popped
     * nodes. If they are equal then return the node else return null.
     */
    public List hasCommonNode(List l1, List l2) {

        if (l1 == null || l2 == null) {

            return null;
        }

        List head1 = l1;
        List head2 = l2;

        Stack<List> stack1 = new Stack<List>();

        Stack<List> stack2 = new Stack<List>();

        while (head1 != null) {

            stack1.push(head1);

            head1 = head1.next;
        }

        while (head2 != null) {

            stack2.push(head2);

            head2 = head2.next;
        }

        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            List node1 = stack1.pop();
            List node2 = stack2.pop();

            if (node1.equals(node2)) {

                return node1;
            }
        }

        return null;
    }

    /**
     * @param l1
     * @param l2
     * @return If there is a common node between two link lists, then their last
     * nodes should be same. Just compare the last node of both the link
     * lists.
     */
    public boolean commonNode(List l1, List l2) {

        if (l1 == null || l2 == null) {

            return false;
        }
        List head1 = l1;
        List head2 = l2;

        while (head1.next != null) {

            head1 = head1.next;
        }

        while (head2.next != null) {

            head2 = head2.next;
        }

        if (head1 == head2) {

            return true;
        }

        return false;
    }

    /**
     * @param head1
     * @param head2
     * @return Yahoo on-site. Given two linked lists, return the node if there
     * is any common node between them else return null.
     */
    public List mergeNode(List head1, List head2) {

        if (head1 == null || head2 == null) {

            return null;
        }

        int len1 = 0;

        int len2 = 0;

        List list1 = head1;
        List list2 = head2;

        while (list1 != null) {

            list1 = list1.next;

            len1++;
        }
        while (list2 != null) {

            list2 = list2.next;

            len2++;
        }

        list1 = head1;
        list2 = head2;

        int diff = Math.abs(len1 - len2);

        int count = 0;

        if (len1 > len2) {

            while (count < diff) {

                list1 = list1.next;
                count++;
            }
        } else if (len1 < len2) {

            while (count < diff) {

                list2 = list2.next;

                count++;
            }
        }

        while (list1 != null || list2 != null) {

            if (list1 == list2) {

                return list1;
            }

            list1 = list1.next;
            list2 = list2.next;
        }
        return null;
    }
}