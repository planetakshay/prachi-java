package practice2023.tree;

import java.util.*;

/**
 * Walmart onsite.
 *
 * Complexity:
 * Time Complexity - O(N) + O(1)  ( look up for the node in the map)
 */
public class NextNodeInTree {
    Tree root;
    Map<Integer, Tree> map;

    public static void main(String[] args) {
        NextNodeInTree nextNodeInTree = new NextNodeInTree();
        Tree root = nextNodeInTree.createTree();
        nextNodeInTree.root = root;
        nextNodeInTree.populateMap(root);
        System.out.println("Nodes to the right: " + nextNodeInTree.getNodesToTheRight(2));
        System.out.println("Nodes to the right: " + nextNodeInTree.getNodesToTheRight(5));
    }

    public List<Integer> getNodesToTheRight(int target) {
        Tree node = map.get(target);
        List<Integer> nodeToRight = new ArrayList<>();
        while (node != null) {
            node = node.next;
            if (node != null) {
                nodeToRight.add(node.value);
            }
        }
        return nodeToRight;
    }

    public void populateMap(Tree root) {
        if (root != null) {
            bfs(root);
        }
    }

    /**
     * for nodes at each level n, set the next pointers for
     * the nodes at level n + 1.
     *
     * Node's left child's next is the node's right child.
     * Node's child's next will be node's next's left child
     * as at current level the nodes should have next pointer
     * set.
     *
     * @param root
     */
    public void noExtraSpace(Tree root) {
        Tree leftMost = root;
        // Keep moving down at each level having reference to the
        // left most node.
        while(leftMost.left != null) { // This is to stop at the left most leaf node.
            // From here on tree the node at current level as
            // if they are nodes in a linked list and
            // start connecting node at the right to the next
            // of the current node.
            Tree head = leftMost;
            while(head != null) {
                head.left.next = head.right;
                if(head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
    }

    public void recursive(Tree node) {
        if(node == null) {
            return;
        }
        if(node.left != null) {
            node.left.next = node.right;
        }

        if(node.right != null && node.next != null) {
            node.right.next = node.next.left;
        }
        recursive(node.left);
        recursive(node.right);
    }

    public void bfs(Tree node) {
        map = new HashMap<>();
        Queue<Tree> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Tree curr = queue.poll();
                // The if condition below is very important
                // without which the last node in the current level
                // will have its next node pointing to the first node
                // of the next level.
                if (i < size - 1) {
                    curr.next = queue.peek();
                }
                map.put(curr.value, curr);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
    }

    public Tree createTree() {
        Tree node1 = new Tree(2);
        Tree node2 = new Tree(3);
        Tree node4 = new Tree(4);
        node1.left = node4;

        Tree node5 = new Tree(5);
        node1.right = node5;

        Tree node6 = new Tree(6);
        node2.left = node6;

        Tree node7 = new Tree(7);
        node2.right = node7;

        Tree root = new Tree(1, node1, node2);
        return root;
    }
}

class Tree {
    int value;
    Tree left;
    Tree right;
    Tree next;

    public Tree(int value) {
        this.value = value;
    }

    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}