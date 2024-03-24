package practice2023.tree;

import java.util.List;

/**
 * IK trees foundation material problems.
 */
public class BSTOperations {
    public BinaryTreeNode buildBst(List<Integer> values) {
        BinaryTreeNode root = null;
        for (int value : values) {
            root = insert(root, value);
        }
        return root;
    }

    private BinaryTreeNode insert(BinaryTreeNode root, int value) {
        BinaryTreeNode node = new BinaryTreeNode(value);
        if (root == null) {
            return node;
        }
        BinaryTreeNode prev = null;
        BinaryTreeNode curr = root;

        while (curr != null) {
            prev = curr;
            if (value == curr.value) {
                return root;
            }
            if (value < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if (value < prev.value) {
            prev.left = node;
        } else {
            prev.right = node;
        }
        return root;
    }

    public boolean searchNodeInBst(BinaryTreeNode root, Integer value) {
        if (root == null) {
            return false;
        }
        BinaryTreeNode curr = root;
        while (curr != null) {
            if (curr.value == value.intValue()) {
                return true;
            }
            if (curr.value < value) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return false;
    }

    /**
     * Time complexity: O(logN). i.e. height of a BALANCED binary tree.
     *
     * @param root
     * @return
     */
    public int findMin(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        BinaryTreeNode curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.value;
    }

    /**
     * Time complexity: O(logN). i.e. height of a BALANCED binary tree.
     *
     * @param root
     * @return
     */
    public int findMax(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        BinaryTreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.value;
    }

    public BinaryTreeNode inorderSuccessor(BinaryTreeNode root, BinaryTreeNode p) {
        BinaryTreeNode successor = null;
        while (root != null) {
            if (p.value >= root.value) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    public BinaryTreeNode inorderPredecessor(BinaryTreeNode root, BinaryTreeNode p) {
        BinaryTreeNode predecessor = null;
        while (root != null) {
            if (p.value <= root.value) {
                root = root.left;
            } else {
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }
}

class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }
}