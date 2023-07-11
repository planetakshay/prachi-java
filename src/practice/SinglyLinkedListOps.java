package practice;

import java.util.HashSet;
import java.util.Set;
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
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        List other = (List) obj;
        if (data != other.data) return false;
        if (next == null) {
            return other.next == null;
        } else return next.equals(other.next);
    }
}

public class SinglyLinkedListOps {
    public static void main(String[] args) {
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
        System.out.println("Nth Node from the beginning is: " + nThNodeFromBeginning.data);
        // head = opsObj.reverse(head);
        opsObj.print(head);

        System.out.println("Reverse in the groups of k nodes: ");
        head = opsObj.reverseByGivenSize(head, 4);
        opsObj.print(head);

        System.out.println("Swap Kth Node: ");
        head = opsObj.swapKthNode(head, 3);
        opsObj.print(head);

        head = opsObj.addNodeBack(head, 8);
        head = opsObj.addNodeBack(head, 32);
        head = opsObj.addNodeBack(head, 256);
        head = opsObj.addNodeBack(head, 2048);
        // Remove duplicate nodes.
        System.out.println("List with duplicates...");
        opsObj.print(head);
        // removeDuplicates(head);
        removeDuplicatesEfficient(head);
        System.out.println("List with unique elements after removal.....");
        opsObj.print(head);

        // Rearrange odd and even nodes.
        List oddEven = new List(1);
        oddEven = opsObj.addNodeBack(oddEven, 3);
        oddEven = opsObj.addNodeBack(oddEven, 5);
        oddEven = opsObj.addNodeBack(oddEven, 7);
        oddEven = opsObj.addNodeBack(oddEven, 2);
        oddEven = opsObj.addNodeBack(oddEven, 4);
        oddEven = opsObj.addNodeBack(oddEven, 6);
        oddEven = opsObj.addNodeBack(oddEven, 8);

        opsObj.print(oddEven);
        System.out.println("Rearraged as odd and even: ");
        oddEvenSorting(oddEven);
        opsObj.print(oddEven);

        // Delete middle node of the list
        System.out.println("Delete middle node of the list. ");
        List deleteMiddleNode = new List(1);
        deleteMiddleNode = opsObj.addNodeBack(deleteMiddleNode, 3);
        deleteMiddleNode = opsObj.addNodeBack(deleteMiddleNode, 4);
        deleteMiddleNode = opsObj.addNodeBack(deleteMiddleNode, 7);
        deleteMiddleNode = opsObj.addNodeBack(deleteMiddleNode, 1);
        deleteMiddleNode = opsObj.addNodeBack(deleteMiddleNode, 2);
        deleteMiddleNode = opsObj.addNodeBack(deleteMiddleNode, 6);
        deleteMiddleNode = deleteMiddleNode(deleteMiddleNode);
        opsObj.print(deleteMiddleNode);

        System.out.println("Delete middle node of the list with only two nodes. ");
        deleteMiddleNode = new List(2);
        deleteMiddleNode = opsObj.addNodeBack(deleteMiddleNode, 1);
        deleteMiddleNode = deleteMiddleNode(deleteMiddleNode);
        opsObj.print(deleteMiddleNode);

        // Find if there is any inersecting nodes. If there is return.

        List n1 = new List(1);
        n1.next = new List(2);
        n1.next.next = new List(3);
        n1.next.next.next = new List(4);
        n1.next.next.next.next = new List(5);
        n1.next.next.next.next.next = new List(6);
        n1.next.next.next.next.next.next = new List(7);
        // list 2
        List n2 = new List(10);
        n2.next = new List(9);
        n2.next.next = new List(8);
        n2.next.next.next = n1.next.next.next;
        opsObj.print(n1);

        opsObj.print(n2);
        System.out.println("Has common node: " + opsObj.intersection(n1, n2).data);

        // Partition the linked list.

        List linkedList = null;
        linkedList = opsObj.addNodeBack(linkedList, 10);
        linkedList = opsObj.addNodeBack(linkedList, 4);
        linkedList = opsObj.addNodeBack(linkedList, 8);
        linkedList = opsObj.addNodeBack(linkedList, 16);
        linkedList = opsObj.addNodeBack(linkedList, 20);
        linkedList = opsObj.addNodeBack(linkedList, 2);
        linkedList = opsObj.addNodeBack(linkedList, 3);
        linkedList = opsObj.addNodeBack(linkedList, 7);
        linkedList = opsObj.addNodeBack(linkedList, 11);
        linkedList = opsObj.addNodeBack(linkedList, 9);
        linkedList = opsObj.addNodeBack(linkedList, 1);
        System.out.println("Original List: ");
        opsObj.print(linkedList);
        int pivot = 16;
        linkedList = opsObj.partition(linkedList, pivot);
        System.out.println("After partitioning around " + pivot + "\n");
        opsObj.print(linkedList);

        List palindrome = null;
        palindrome = opsObj.addNodeBack(palindrome, 1);
        palindrome = opsObj.addNodeBack(palindrome, 2);
        palindrome = opsObj.addNodeBack(palindrome, 3);
        palindrome = opsObj.addNodeBack(palindrome, 4);
        palindrome = opsObj.addNodeBack(palindrome, 5);
        palindrome = opsObj.addNodeBack(palindrome, 4);
        palindrome = opsObj.addNodeBack(palindrome, 3);
        palindrome = opsObj.addNodeBack(palindrome, 2);
        palindrome = opsObj.addNodeBack(palindrome, 1);

        System.out.println("Original Palindrome List: ");
        opsObj.print(palindrome);
        System.out.println("Is list a palindrome: " + isPalindrome(palindrome));

        // Linked List with Cycle

        List cycle = new List(50);
        cycle.next = new List(20);
        cycle.next.next = new List(15);
        cycle.next.next.next = new List(4);
        cycle.next.next.next.next = new List(10);

        // Create a loop
        cycle.next.next.next.next.next = cycle.next.next;

        List collisionNode = opsObj.collision(cycle);
        String loop = collisionNode == null ? "None" : String.valueOf(collisionNode.data);
        System.out.println("Cycle starts at: " + loop);

        // Delete nth from the end of the linked list.
        linkedList = null;
        linkedList = opsObj.addNodeBack(linkedList, 10);
        linkedList = opsObj.addNodeBack(linkedList, 4);
        linkedList = opsObj.addNodeBack(linkedList, 8);
        linkedList = opsObj.addNodeBack(linkedList, 16);
        linkedList = opsObj.addNodeBack(linkedList, 20);
        linkedList = opsObj.addNodeBack(linkedList, 2);
        linkedList = opsObj.addNodeBack(linkedList, 3);
        linkedList = opsObj.addNodeBack(linkedList, 7);
        linkedList = opsObj.addNodeBack(linkedList, 11);
        linkedList = opsObj.addNodeBack(linkedList, 9);
        linkedList = opsObj.addNodeBack(linkedList, 1);
        System.out.println("Original List: ");
        opsObj.print(linkedList);
        int n = 4;
        linkedList = opsObj.nThFromLastDelete(linkedList, n);
        System.out.println("After deleting " + n + "th node from end of the list\n");
        opsObj.print(linkedList);


        System.out.println("Remove given node. The node is not the head or the tail of the linked list");
    }

    /**
     * The method below cannot delete if the node (to be deleted)
     * in the argument is the last node of the linked list.
     *
     * @param node
     */
    public static void removeMiddleNode(List node) {
        if (node != null && node.next != null) {
            node.data = node.next.data;
            node.next = node.next.next;
        }
    }

    /**
     * following implementation uses two pointer technique and no extra space.
     * As a result the space complexity of this algorithm is o(1)(constant space.)
     * However the time complexity is o(N2) (big-o of N squared.)
     * <p>
     * To improve time complexity to O(N) we can use a Set. that is a tradeoff
     * to achieve faster executing time. With additional space, the algorithm will
     * be O(N) time complexity and O(N) space complexity.
     *
     * @param head
     */
    public static void removeDuplicates(List head) {
        if (head != null && head.next != null) {
            List current = head;
            while (current != null) {
                List runner = current;
                while (runner.next != null) {
                    if (runner.next.data == current.data) {
                        runner.next = runner.next.next;
                    } else {
                        runner = runner.next;
                    }
                }
                current = current.next;
            }
        }
    }

    public static void removeDuplicatesEfficient(List head) {
        Set<Integer> nodes = new HashSet<>();
        if (head != null && head.next != null) {
            List current = head;
            List previous = null;
            while (current != null) {
                if (nodes.contains(current.data)) {
                    previous.next = current.next;
                } else {
                    nodes.add(current.data);
                    previous = current;
                }
                current = current.next;
            }
        }
    }

    public static List oddEvenSorting(List head) {
        if (head == null || head.next == null) {
            return head;
        }
        List odd = head;
        List even = head.next;
        List firstEven = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = firstEven;
        return odd;
    }

    public static List deleteMiddleNode(List head) {
        List curr = head;
        List fast = head;

        if (head == null || head.next != null) {
            return null;
        }
        while (fast != null && fast.next != null) {
            curr = curr.next;
            fast = fast.next.next;
        }
        // At this point current is at the middle of the list
        if (curr != null) {
            if (curr.next == null) {
                curr = null;
                head.next = curr;
            } else {
                curr.data = curr.next.data;
                curr.next = curr.next.next;
            }
        }
        return head;
    }

    public static boolean isPalindrome(List l1) {
        if (l1 == null) {
            return false;
        }
        List current = l1;
        Set<Integer> nodes = new HashSet<>();
        while (current != null) {
            int data = current.data;
            if (nodes.contains(data)) {
                nodes.remove(data);
            } else {
                nodes.add(data);
            }
            current = current.next;
        }
        return nodes.size() <= 1;
    }

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
        List slow = first, fast = first; // create two references.
        while (true) {
            slow = slow.next; // 1 hop.
            if (fast.next != null) fast = fast.next.next; // 2 hops.
            else return false; // next node null => no loop.
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
            for (int index = 0; index < n; index++) {
                if (temp == null) {
                    return null;
                }
                temp = temp.next;
            }
            while (temp != null) {
                node = node.next;
                temp = temp.next;
            }
            return node;
        }
        return null;
    }

    public List nThFromLastDelete(List head, int n) {
        if (head != null) {
            List temp = head;
            List node = head;
            for (int index = 0; index < n; index++) {
                if (temp == null) {
                    return null;
                }
                temp = temp.next;
            }
            while (temp != null) {
                node = node.next;
                temp = temp.next;
            }
            if(node != null) {
                List next = node.next;
                node.data = next.data;
                node.next = next.next;
            }
            return head;
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
        List temp = kthFromStart; // reference to Kth node from start.
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
        return head1 == head2;
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

    /**
     * This will not work if list sizes are not same.
     *
     * @param l1
     * @param l2
     * @return
     */
    public List intersection(List l1, List l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        while (l1 != null && l2 != null) {
            if (l1 == l2) {
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }

    public List partition(List node, int pivot) {
        if (node == null) {
            return null;
        }
        List head = node;
        List tail = node;

        while (node != null) {
            // Preserve current next
            List next = node.next;
            if (node.data < pivot) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        // Remember to set tail.next to null otherwise you will get stack overflow.
        tail.next = null;
        return head;
    }

    public List collision(List head) {
        List slow = head, fast = head;
        boolean loopDetected = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loopDetected = true;
                break;
            }
        }
        // if fast is now or next of fast is null that indicates
        // there are no cycles in the linked list.
       /* if (fast == null || fast.next == null) {
            return null;
        } */
        // Now we are at a meeting point of fast and slow. Since slow has moved
        // k nodes and fast is at the same position, we will move slow to the
        // start of the linked list and have them move at the same speed this time.
        // And have slow and fast move again. At some point they both will be again
        // at the meeting point since now we know there is a loop in the linked list.

        if(loopDetected) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        // Now fast and slow both are at the node from where the cycle starts.
        return fast;
    }
}