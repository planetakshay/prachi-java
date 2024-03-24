package practice2023.tree;

import java.util.*;

public class BinarySearchTree {
    private int gstSum = 0;
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode node = null;
        node = bst.insert(node, 10);
        node = bst.insert(node, 9);
        node = bst.insert(node, 7);
        node = bst.insert(node, 5);
        node = bst.insert(node, 30);
        node = bst.insert(node, 25);
        node = bst.insert(node, 20);
        node = bst.insert(node, 15);
        node = bst.insert(node, 4);
        node = bst.insert(node, 8);
        node = bst.insert(node, 40);
        node = bst.insert(node, 1);
        node = bst.insert(node, 6);

        bst.printTreeLayers(node);
        System.out.println("\nDepth: " + bst.maxDepth(node));
        System.out.println("Lowest Common Ancestor: " + bst.findLowestCommonAncestor(node, 40, 15).val);
        System.out.println(bst.treeDiameter(node));
        System.out.println(bst.size(node));

        // bst.inOrderTraversal(node);
        nonRecursiveInOrderTraversal(node);
        TreeNode binaryTree = null;
        binaryTree = bst.insert(binaryTree, 10);
        binaryTree = bst.insert(binaryTree, 9);
        binaryTree = bst.insert(binaryTree, 7);
        binaryTree = bst.insert(binaryTree, 5);
        binaryTree = bst.insert(binaryTree, 30);
        binaryTree = bst.insert(binaryTree, 25);
        binaryTree = bst.insert(binaryTree, 20);
        binaryTree = bst.insert(binaryTree, 15);
        binaryTree = bst.insert(binaryTree, 4);
        binaryTree = bst.insert(binaryTree, 8);
        binaryTree = bst.insert(binaryTree, 40);
        binaryTree = bst.insert(binaryTree, 1);
        binaryTree = bst.insert(binaryTree, 6);
        binaryTree = bst.insert(binaryTree, 14);
        binaryTree = bst.insert(binaryTree, 18);
        binaryTree = bst.insert(binaryTree, 28);
        binaryTree = bst.insert(binaryTree, 22);
        binaryTree = bst.insert(binaryTree, 12);
        binaryTree = bst.insert(binaryTree, 50);

        System.out.println("Updated height after removing subtree of 30: " + bst.removeSubtree(30, binaryTree));

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        bst.printTreeLayers(bst.minimalTree(array));

        System.out.println("\n\nPrint tree by levels... ");

        binaryTree = null;
        binaryTree = bst.insert(binaryTree, 10);
        binaryTree = bst.insert(binaryTree, 9);
        binaryTree = bst.insert(binaryTree, 7);
        binaryTree = bst.insert(binaryTree, 5);
        binaryTree = bst.insert(binaryTree, 30);
        binaryTree = bst.insert(binaryTree, 25);
        binaryTree = bst.insert(binaryTree, 20);
        binaryTree = bst.insert(binaryTree, 15);
        binaryTree = bst.insert(binaryTree, 4);
        binaryTree = bst.insert(binaryTree, 8);
        binaryTree = bst.insert(binaryTree, 40);
        binaryTree = bst.insert(binaryTree, 1);
        binaryTree = bst.insert(binaryTree, 6);
        binaryTree = bst.insert(binaryTree, 14);
        binaryTree = bst.insert(binaryTree, 18);
        binaryTree = bst.insert(binaryTree, 28);
        binaryTree = bst.insert(binaryTree, 22);
        binaryTree = bst.insert(binaryTree, 12);
        binaryTree = bst.insert(binaryTree, 50);

        List<List<TreeNode>> levels = bst.createLevelLinkedList(binaryTree);
        levels.forEach(level -> {
            level.forEach(vertex -> {
                System.out.print(vertex.val + "\t");
            });
            System.out.println();
        });

        System.out.println("In order successor of the node...");
        binaryTree = bst.initTree(bst);
        TreeNode curr = binaryTree.left.right.right;
        System.out.println("Inorder Successor of " + curr.val + " : " + bst.inOrderSuccessor(curr).val);
        // Find closes value in the binary search tree.
        binaryTree = null;
        binaryTree = bst.insert(binaryTree, 4);
        binaryTree = bst.insert(binaryTree, 2);
        binaryTree = bst.insert(binaryTree, 5);
        binaryTree = bst.insert(binaryTree, 1);
        binaryTree = bst.insert(binaryTree, 3);

        double target = 3.7;
        System.out.println("closest to " + target + " in bst: " + bst.closestValue(binaryTree, target));

        // bst to GST.
        // https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/

        binaryTree = null;
        binaryTree = bst.insert(binaryTree, 4);
        binaryTree = bst.insert(binaryTree, 1);
        binaryTree = bst.insert(binaryTree, 6);
        binaryTree = bst.insert(binaryTree, 0);
        binaryTree = bst.insert(binaryTree, 2);
        binaryTree = bst.insert(binaryTree, 5);
        binaryTree = bst.insert(binaryTree, 7);
        binaryTree = bst.insert(binaryTree, 3);
        binaryTree = bst.insert(binaryTree, 8);
        binaryTree = bst.bstToGst(binaryTree);
        System.out.println("bstToGst with helper. ");
        bst.printTreeLayers(binaryTree);

        binaryTree = null;
        bst.gstSum = 0;
        binaryTree = bst.insert(binaryTree, 4);
        binaryTree = bst.insert(binaryTree, 1);
        binaryTree = bst.insert(binaryTree, 6);
        binaryTree = bst.insert(binaryTree, 0);
        binaryTree = bst.insert(binaryTree, 2);
        binaryTree = bst.insert(binaryTree, 5);
        binaryTree = bst.insert(binaryTree, 7);
        binaryTree = bst.insert(binaryTree, 3);
        binaryTree = bst.insert(binaryTree, 8);
        binaryTree = bst.bstToGstNoHelper(binaryTree);
        System.out.println("\nbstToGst without helper. ");
        bst.printTreeLayers(binaryTree);

        binaryTree = null;
        binaryTree = bst.insert(binaryTree, 3);
        binaryTree = bst.insert(binaryTree, 4);

        binaryTree = bst.insert(binaryTree, 5);
        binaryTree = bst.insert(binaryTree, 1);
        binaryTree = bst.insert(binaryTree, 2);

        TreeNode subTree = new TreeNode();
        subTree = bst.insert(subTree, 4);
        subTree = bst.insert(subTree, 1);
        subTree = bst.insert(subTree, 2);

        System.out.println("\nisSubTree. " + bst.isSubtree(binaryTree, subTree));

        System.out.println("Set Next....");
        binaryTree = null;
        binaryTree = bst.insert(binaryTree, 10);
        binaryTree = bst.insert(binaryTree, 9);
        binaryTree = bst.insert(binaryTree, 7);
        binaryTree = bst.insert(binaryTree, 5);
        binaryTree = bst.insert(binaryTree, 30);
        binaryTree = bst.insert(binaryTree, 25);
        binaryTree = bst.insert(binaryTree, 20);
        binaryTree = bst.insert(binaryTree, 15);
        binaryTree = bst.insert(binaryTree, 4);
        binaryTree = bst.insert(binaryTree, 8);
        binaryTree = bst.insert(binaryTree, 40);
        binaryTree = bst.insert(binaryTree, 1);
        binaryTree = bst.insert(binaryTree, 6);
        binaryTree = bst.insert(binaryTree, 14);
        binaryTree = bst.insert(binaryTree, 18);
        binaryTree = bst.insert(binaryTree, 28);
        binaryTree = bst.insert(binaryTree, 22);
        binaryTree = bst.insert(binaryTree, 12);
        binaryTree = bst.insert(binaryTree, 50);
        bst.printLayersWithNext(bst.setNext(binaryTree));

        binaryTree = null;
        binaryTree = bst.insert(binaryTree, 10);
        binaryTree = bst.insert(binaryTree, 5);
        binaryTree = bst.insert(binaryTree, 1);
        binaryTree = bst.insert(binaryTree, 7);
        binaryTree = bst.insert(binaryTree, 15);
        binaryTree = bst.insert(binaryTree, 12);
        binaryTree = bst.insert(binaryTree, 18);

        binaryTree = bst.closestValue(binaryTree, binaryTree, Integer.MAX_VALUE, 13);
        System.out.println("\nclosest node to binaryTree: " + binaryTree.val);

        binaryTree = null;
        binaryTree = bst.insert(binaryTree, 10);
        binaryTree = bst.insert(binaryTree, 5);
        binaryTree = bst.insert(binaryTree, 1);
        binaryTree = bst.insert(binaryTree, 7);
        binaryTree = bst.insert(binaryTree, 15);
        binaryTree = bst.insert(binaryTree, 12);
        binaryTree = bst.insert(binaryTree, 18);

        binaryTree = bst.closestValue(binaryTree, binaryTree, Integer.MAX_VALUE, 4);
        System.out.println("\nclosest node to binaryTree: " + binaryTree.val);

        binaryTree = null;
        binaryTree = bst.insert(binaryTree, 92);
        binaryTree = bst.insert(binaryTree, 88);
        binaryTree = bst.insert(binaryTree, 51);
        binaryTree = bst.insert(binaryTree, 55);
        binaryTree = bst.insert(binaryTree, 36);
        binaryTree = bst.insert(binaryTree, 69);
        binaryTree = bst.insert(binaryTree, 37);
        binaryTree = bst.insert(binaryTree, 97);
        binaryTree = bst.insert(binaryTree, 56);
        binaryTree = bst.insert(binaryTree, 49);
        bst.preOrderTraversal(binaryTree);
        System.out.println("\nPreorder Traversal with Indentation: ");
        bst.preOrderTraversalWithIndentation(binaryTree, 0);

        System.out.println("\nConvert tree to string...");
        binaryTree = null;
        binaryTree = bst.insert(binaryTree, 10);
        binaryTree = bst.insert(binaryTree, 12);
        binaryTree = bst.insert(binaryTree, 3);
        binaryTree = bst.insert(binaryTree, 4);
        bst.treeToString(binaryTree);
    }

    public static void morrisInorderTraversal(TreeNode root) {
        if (root != null) {
            TreeNode curr = root;
            TreeNode prev;
            while (curr != null) {
                if (curr.left == null) {
                    System.out.print(curr.val + "\t");
                } else {
                    prev = curr.left;
                    while (prev.right != null && prev.right != curr) {
                        prev = prev.right;
                    }
                    if (prev.right == null) {
                        prev.right = curr;
                        curr = curr.left;
                    } else {
                        prev.right = null;
                        System.out.print(curr.val + "\t");
                        curr = curr.right;
                    }
                }
            }
        }
    }

    public static void nonRecursiveInOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.println("In order traversal using stack solution.");
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                // VERY IMPORTANT
                // curr will be null at the end of inner while loop.
                // So preserve reference of the last node pushed
                // to stack before printing the value of the popped node.
                curr = stack.pop();
                System.out.print(curr.val + "\t");
                curr = curr.right;
            }
        }
    }

    public TreeNode initTree(BinarySearchTree bst) {
        TreeNode binaryTree = null;
        binaryTree = insert(binaryTree, 20);
        binaryTree = insert(binaryTree, 8);
        binaryTree = insert(binaryTree, 22);
        binaryTree = insert(binaryTree, 4);
        binaryTree = insert(binaryTree, 12);
        binaryTree = insert(binaryTree, 10);
        binaryTree = insert(binaryTree, 14);
        return binaryTree;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + "\t");
        inOrderTraversal(root.right);
    }

    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "\t");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void preOrderTraversalWithIndentation(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        for(int i=1;i<=level;i++) {
            System.out.print(" ");
        }
        System.out.print(root.val + " \n");
        preOrderTraversalWithIndentation(root.left, level + 1);
        preOrderTraversalWithIndentation(root.right, level + 1);
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + "\t");
    }


    public TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            node = new TreeNode();
            node.val = value;
        } else {
            if (node.val > value) {
                node.left = insert(node.left, value);
                node.left.parent = node;
            } else if (node.val <= value) {
                node.right = insert(node.right, value);
                node.right.parent = node;
            }
        }
        return node;
    }

    public TreeNode deleteNode(TreeNode root, int value) {
        if (root == null) {
            return root;
        }
        if (root.val > value) {
            return deleteNode(root.left, value);
        } else if (root.val < value) {
            return deleteNode(root.right, value);
        }
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeNode succParent = root;
            // Find successor
            TreeNode succ = root.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }
            // Delete successor.  Since successor
            // is always left child of its parent
            // we can safely make successor's right
            // right child as left of its parent.
            // If there is no succ, then assign
            // succ.right to succParent.right
            if (succParent != root) {
                succParent.left = succ.right;
            } else {
                succParent.right = succ.right;
            }
            // Copy Successor Data to root
            root.val = succ.val;
            // Delete Successor and return root
            return root;
        }
    }

    /**
     * BFS is a way of traversing a Binary Search Tree.
     * HP on-site. This is also called Breadth first search (BFS) algorithm
     * <p>
     * Use Queue data structure for iterative solution(non-recursive) for BFS
     * The tree is printed layer by layer.
     *
     * @param root
     */
    public void printTreeLayers(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        // used as a line break while printing.
        queue.add(null);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            // Following condition takes care of the line break at each level
            // By adding line break into the queue.
            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    System.out.println();
                }
            } else {
                System.out.print(node.val + "\t");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public void printLayersWithNext(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        // used as a line break while printing.
        queue.add(null);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            // Following condition takes care of the line break at each level
            // By adding line break into the queue.
            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    System.out.println();
                }
            } else {
                System.out.print(node.val);
                String next = node.next != null ? String.valueOf(node.next.val) : "null";
                System.out.print("\t node.next: " + next + "\t");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    public int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.min(minDepth(node.left), minDepth(node.right));
    }

    // The runtime of this implementation is O(NlogN) which is not very efficient.
    boolean isBalanced(TreeNode node) {
        return maxDepth(node) - minDepth(node) <= 1;
    }

    /*
     Runtime of following isBalanced is O(N) and O(H) size.
     Where H is the height of the tree and N is no of vertices.
     Return value of Integer.MIN_VALUE indicates error condition.
     either left subtree is imbalanced or right subtree is imbalanced
     or the tree is imbalanced.
    */

    public boolean isBalancedEfficient(TreeNode root) {
        return calculateHeight(root) != Integer.MIN_VALUE;
    }

    public int calculateHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = calculateHeight(node.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int rightHeight = calculateHeight(node.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int diff = Math.abs(rightHeight - leftHeight);
        if (diff > 1) {
            // This means the tree is not balanced and hence return error code
            // which in our example is the least value a Java 32-bit integer can hold.
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int height = Math.max(height(root.left), height(root.right)) + 1;
        return height;
    }

    public int heightLeft(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + heightLeft(node.left);
    }

    public int heightRight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + heightRight(node.right);
    }

    // Longest path between any two nodes of the tree.
    // The path may not pass through the tree node.
    public int treeDiameter(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lHeight = heightLeft(node.left);
        int rHeight = heightRight(node.right);
        int ldiameter = treeDiameter(node.left);
        int rdiameter = treeDiameter(node.right);
        return Math.max(lHeight + rHeight + 1, Math.max(ldiameter, rdiameter));
    }

    // LCA for a Binary Search Tree Node.
    public TreeNode findLowestCommonAncestor(TreeNode root, int value1, int value2) {
        while (root != null) {
            if (root.val > value1 && root.val > value2) {
                root = root.left;
            } else if (root.val < value1 && root.val < value2) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + 1 + size(root.right);
    }

    /**
     * Amazon on-site. Given two binary trees, determine if they are mirror of
     * each other.
     *
     * https://leetcode.com/problems/symmetric-tree/
     *
     * @param a
     * @param b
     * @return
     */
    boolean areMirrorTrees(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.val == b.val
                && areMirrorTrees(a.left, b.right)
                && areMirrorTrees(a.right, b.left);
    }

    public boolean isValid(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        return node.val > min && node.val < max
                && isValidBST(node.left, min, node.val)
                && isValidBST(node.right, node.val, max);
    }

    private int removeSubtree(int val, TreeNode root) {
        System.out.println("\n\n");
        printTreeLayers(root);
        int height = height(root);
        System.out.println("\nOriginalHeight: " + height);
        if (root == null) {
            return 0;
        }
        TreeNode current = root;
        TreeNode parent = root;
        boolean leftChild = false;
        while (current.val != val) {
            parent = current;
            if (val < current.val) {
                current = current.left;
                leftChild = true;
            } else {
                current = current.right;
            }
        }
        if (current == null) {
            // Value was not found. A scenario to log.
            return height(root);
        } else {
            if (leftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        printTreeLayers(root);
        height = height(root);
        System.out.println("\nupdatedHeight: " + height);
        return height;
    }

    public TreeNode minimalTree(int[] array) {
        System.out.println("Convert array into minimal tree...");
        if (array == null || array.length == 0) {
            return null;
        }
        return createMinimalBST(array, 0, array.length - 1);
    }

    /**
     * @param array
     * @param start start index in the subarray
     * @param end   end index in the subarray
     * @return
     */
    public TreeNode createMinimalBST(int[] array, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(array[mid]);
        node.left = createMinimalBST(array, start, mid - 1);
        node.right = createMinimalBST(array, mid + 1, end);
        return node;
    }
    public List<List<TreeNode>> createLevelLinkedList(TreeNode root) {
        List<List<TreeNode>> lists = new LinkedList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }
    public void createLevelLinkedList(TreeNode node, List<List<TreeNode>> lists, int level) {
        if (node == null) {
            return;
        }
        List<TreeNode> list = null;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(node);
        createLevelLinkedList(node.left, lists, level + 1);
        createLevelLinkedList(node.right, lists, level + 1);
    }

    public TreeNode leftMostchild(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public TreeNode inOrderSuccessor(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return leftMostchild(node);
        } else {
            TreeNode curr = node;
            TreeNode parent = node.parent;
            while (parent != null && parent.left != curr) {
                curr = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    public Node transformToDoublyLinkedList(TreeNode tree, Node head) {
        if (tree == null) {
            return null;
        }

        transformToDoublyLinkedList(tree.left, head);
        tree.left = null;
        System.out.print(tree.val + "\t");
        Node node = new Node();
        node.val = String.valueOf(tree.val);
        inOrderTraversal(tree.right);

        return node;
    }

    public int closestValue(TreeNode root, double target) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        long pred = Integer.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (pred <= target && target < root.val) {
                return Math.abs(pred - target) <= Math.abs(root.val - target) ? (int) pred : root.val;
            }
            pred = root.val;
            root = root.right;
        }
        return (int) pred;
    }

    /**
     * Coupang phone screen
     *
     * @param root
     * @param closest
     * @param diff
     * @param target
     * @return
     */
    public TreeNode closestValue(TreeNode root, TreeNode closest, int diff, int target) {
        if(root == null) {
            return closest;
        }

        if(root.val == target) {
            return root;
        }

        int currDiff = Math.abs(root.val - target);
        if(currDiff < diff) {
            diff = currDiff;
            closest = root;
        }

        if(root.val < target) {
            return closestValue(root.right, closest, diff, target);
        } else {
            return closestValue(root.left, closest, diff, target);
        }
    }

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return root;
        }
        gstHelper(root);
        return root;
    }

    public void gstHelper(TreeNode node) {
        if (node == null) {
            return;
        }
        bstToGst(node.right);
        gstSum += node.val;
        node.val = gstSum;
        bstToGst(node.left);
    }

    public TreeNode bstToGstNoHelper(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right != null) {
            bstToGstNoHelper(root.right);
        }
        root.val += gstSum;
        gstSum = root.val; // preserve last sum for next recursive call.
        if (root.left != null) {
            bstToGstNoHelper(root.left);
        }
        return root;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isIdentical(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isIdentical(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == null && node2 == null;
        }
        return node1.val == node2.val && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
    }

    /**
     * @param root
     * @return Snowflake phone screen.
     */
    private TreeNode setNext(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (i < size - 1) {
                    current.next = queue.peek();
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return root;
    }

    private TreeNode setNoExtraSpace(TreeNode root) {
        if (root == null) {
            return root;
        }
        // At root level
        TreeNode leftMost = root;
        // Once we reach at the last level (where left and right of the node
        // will be empty.
        while(leftMost.left != null) {
            TreeNode head = leftMost;
            while(head != null) {
                head.left.next = head.right;
                if(head.next != null) {
                    head.right.next = head.next.left;
                }
                // We are moving to the right at the same level.
                // next pointer will help move along the level
                // regardless of the parent.
                head = head.next;
            }
            // go down to left most node at the next level.
            leftMost = leftMost.left;
        }
        return root;
    }
    private List<Integer> rightView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) {
                TreeNode node = queue.poll();
                if(i == len - 1) {
                    results.add(node.val);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return results;
    }
    private List<Integer> leftView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) {
                TreeNode node = queue.poll();
                if(i == 0) {
                    results.add(node.val);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return results;
    }
    public TreeNode searchBST(TreeNode root, int data) {
        return search(root, data);
    }
    public TreeNode search(TreeNode node, int val) {
        if (node == null || node.val == val) {
            return node;
        }
        return node.val <= val ? search(node.right, val) : search(node.left, val);
    }

    public TreeNode searchBSTIterative(TreeNode node, int val) {
        while (node != null && node.val != val) {
            if (node.val <= val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return node;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * Use BFS and swap the nodes in the queue.
     * And add the left and/or right subtrees back to the queue.
     *
     * @param root
     * @return
     */
    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode curr = queue.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        return root;
    }

    /**
     * This is a recursive DFS solution.
     * @param root
     * @return
     */
    public TreeNode reverseOddLevelTree(TreeNode root) {
        dfs(root.left, root.right, true);
        return root;
    }
    public void dfs(TreeNode left, TreeNode right, boolean isOdd) {
        if(left == null) {
            return;
        }
        if(isOdd) {
            final int data = left.val;
            left.val = right.val;
            right.val = data;
        }
        dfs(left.left, right.right, !isOdd);
        dfs(left.right, right.left, !isOdd);
    }
    public List<Integer> postOrderTraversalIterative(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        if (root == null) {
            return traversal;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);
            if (node.left != null) {
                s1.push(node.left);
            }
            if (node.right != null) {
                s1.push(node.right);
            }
        }
        while (!s2.isEmpty()) {
            traversal.add(s2.pop().val);
        }
        return traversal;
    }

    /**
     * Solve using recursive pre-order traversal.
     * @param root
     * @return
     */
    public void treeToString(TreeNode root) {
        this.printTreeLayers(root);
        StringBuilder builder = new StringBuilder();
        recursivePreOrder(root, builder);
        System.out.println("\nTree to String: " + builder.toString());
    }

    private void recursivePreOrder(TreeNode node, StringBuilder builder) {
        if(node == null) {
            return;
        }
        builder.append(node.val);
        if(node.left == null && node.right == null) {
            return;
        }
        if(node.left != null) {
            builder.append("(");
            recursivePreOrder(node.left, builder);
            builder.append(")");
        }
        if(node.right != null) {
            builder.append("(");
            recursivePreOrder(node.right, builder);
            builder.append(")");
        }
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    TreeNode next;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }
}

class Node {
    String val;
    Node left, right;
}