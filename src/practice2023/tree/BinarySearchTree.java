package practice2023.tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeStructure node = null;
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
        System.out.println("Lowest Common Ancestor: " + bst.findLowestCommonAncestor(node, 40, 15).data);
        System.out.println(bst.treeDiameter(node));
        System.out.println(bst.size(node));

        // bst.inOrderTraversal(node);
        bst.nonRecursiveInOrderTraversal(node);
        TreeStructure binaryTree = null;
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

        List<List<TreeStructure>> levels = bst.createLevelLinkedList(binaryTree);
        levels.forEach(level -> {
            level.forEach(vertex -> {
                System.out.print(vertex.data + "\t");
            });
            System.out.println();
        });

        System.out.println("In order successor of the node...");
        binaryTree = bst.initTree(bst);
        TreeStructure curr = binaryTree.left.right.right;
        System.out.println("Inorder Successor of " + curr.data + " : " + bst.inOrderSuccessor(curr).data);
    }

    public static void nonRecursiveInOrderTraversal(TreeStructure root) {
        if (root != null) {
            System.out.println("In order traversal iterative solution.");
            Stack<TreeStructure> stack = new Stack<>();
            TreeStructure curr = root;
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
                System.out.print(curr.data + "\t");
                curr = curr.right;
            }
        }
    }

    public TreeStructure initTree(BinarySearchTree bst) {
        TreeStructure binaryTree = null;
        binaryTree = insert(binaryTree, 20);
        binaryTree = insert(binaryTree, 8);
        binaryTree = insert(binaryTree, 22);
        binaryTree = insert(binaryTree, 4);
        binaryTree = insert(binaryTree, 12);
        binaryTree = insert(binaryTree, 10);
        binaryTree = insert(binaryTree, 14);
        return binaryTree;
    }

    public void inOrderTraversal(TreeStructure root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + "\t");
        inOrderTraversal(root.right);
    }

    public void preOrderTraversal(TreeStructure root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + "\t");
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(TreeStructure root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
        System.out.print(root.data + "\t");
    }


    public TreeStructure insert(TreeStructure node, int value) {
        if (node == null) {
            node = new TreeStructure();
            node.data = value;
        } else {
            if (node.data > value) {
                node.left = insert(node.left, value);
                node.left.parent = node;
            } else if (node.data <= value) {
                node.right = insert(node.right, value);
                node.right.parent = node;
            }
        }
        return node;
    }

    public TreeStructure deleteNode(TreeStructure root, int value) {
        if (root == null) {
            return root;
        }
        if (root.data > value) {
            return deleteNode(root.left, value);
        } else if (root.data < value) {
            return deleteNode(root.right, value);
        }
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeStructure succParent = root;
            // Find successor
            TreeStructure succ = root.right;
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
            root.data = succ.data;
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
    public void printTreeLayers(TreeStructure root) {
        Queue<TreeStructure> queue = new LinkedList<TreeStructure>();
        queue.add(root);
        // used as a line break while printing.
        queue.add(null);
        TreeStructure node;
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
                System.out.print(node.data + "\t");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public int maxDepth(TreeStructure node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    public int minDepth(TreeStructure node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.min(minDepth(node.left), minDepth(node.right));
    }

    // The runtime of this implementation is O(NlogN) which is not very efficient.
    boolean isBalanced(TreeStructure node) {
        return maxDepth(node) - minDepth(node) <= 1;
    }

    /*
     Runtime of following isBalanced is O(N) and O(H) size.
     Where H is the height of the tree and N is no of vertices.
     Return value of Integer.MIN_VALUE indicates error condition.
     either left subtree is imbalanced or right subtree is imbalanced
     or the tree is imbalanced.
    */

    public boolean isBalancedEfficient(TreeStructure root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public int checkHeight(TreeStructure node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = checkHeight(node.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int rightHeight = checkHeight(node.right);
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

    public int height(TreeStructure root) {
        if (root == null) {
            return -1;
        }
        int height = Math.max(height(root.left), height(root.right)) + 1;
        return height;
    }

    public int heightLeft(TreeStructure node) {
        if (node == null) {
            return -1;
        }
        return 1 + heightLeft(node.left);
    }

    public int heightRight(TreeStructure node) {
        if (node == null) {
            return -1;
        }
        return 1 + heightRight(node.right);
    }

    public int treeDiameter(TreeStructure node) {
        if (node == null) {
            return 0;
        }
        int lHeight = heightLeft(node.left);
        int rHeight = heightRight(node.right);
        int ldiameter = treeDiameter(node.left);
        int rdiameter = treeDiameter(node.right);
        return Math.max(lHeight + rHeight + 1, Math.max(ldiameter, rdiameter));
    }

    public TreeStructure findLowestCommonAncestor(TreeStructure root, int value1, int value2) {
        while (root != null) {
            if (root.data > value1 && root.data > value2) {
                root = root.left;
            } else if (root.data < value1 && root.data < value2) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    public int size(TreeStructure root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + 1 + size(root.right);
    }

    /**
     * Amazon on-site. Given two binary trees, determine if they are mirror of
     * each other.
     *
     * @param a
     * @param b
     * @return
     */
    boolean areMirrorTrees(TreeStructure a, TreeStructure b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.data == b.data && areMirrorTrees(a.left, b.right) && areMirrorTrees(a.right, b.left);
    }

    public boolean isValid(TreeStructure root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeStructure node, int min, int max) {
        if (node == null) return true;
        return node.data > min && node.data < max && isValidBST(node.left, min, node.data) && isValidBST(node.right, node.data, max);
    }

    private int removeSubtree(int val, TreeStructure root) {
        System.out.println("\n\n");
        printTreeLayers(root);
        int height = height(root);
        System.out.println("\nOriginalHeight: " + height);
        if (root == null) {
            return 0;
        }
        TreeStructure current = root;
        TreeStructure parent = root;
        boolean leftChild = false;
        while (current.data != val) {
            parent = current;
            if (val < current.data) {
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

    public TreeStructure minimalTree(int[] array) {
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
    public TreeStructure createMinimalBST(int[] array, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeStructure node = new TreeStructure(array[mid]);
        node.left = createMinimalBST(array, start, mid - 1);
        node.right = createMinimalBST(array, mid + 1, end);
        return node;
    }

    public void createLevelLinkedList(TreeStructure node, List<List<TreeStructure>> lists, int level) {
        if (node == null) {
            return;
        }
        List<TreeStructure> list = null;
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

    public List<List<TreeStructure>> createLevelLinkedList(TreeStructure root) {
        List<List<TreeStructure>> lists = new LinkedList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    public TreeStructure leftMostchild(TreeStructure node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public TreeStructure inOrderSuccessor(TreeStructure node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return leftMostchild(node);
        } else {
            TreeStructure curr = node;
            TreeStructure parent = node.parent;
            while (parent != null && parent.left != curr) {
                curr = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }
}

class TreeStructure {
    int data;
    TreeStructure left;
    TreeStructure right;
    TreeStructure parent;

    TreeStructure() {
    }

    TreeStructure(int data) {
        this.data = data;
    }
}