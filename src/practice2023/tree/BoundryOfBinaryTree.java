package practice2023.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class BoundryOfBinaryTree {
    List<Integer> boundry;

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        boundry = new ArrayList<>();
        if (root == null) {
            return boundry;
        }
        boundry.add(root.val);
        left(root.left);
        leaves(root.left);
        leaves(root.right);
        right(root.right);
        return boundry;
    }
    private void left(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        boundry.add(node.val);
        if (node.left != null) {
            left(node.left);
        } else if (node.right != null) {
            left(node.right);
        }
    }
    private void right(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        if (node.right != null) {
            right(node.right);
        } else if (node.left != null) {
            right(node.left);
        }
        boundry.add(node.val);
    }
    private void leaves(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            boundry.add(node.val);
        }
        leaves(node.left);
        leaves(node.right);
    }
}