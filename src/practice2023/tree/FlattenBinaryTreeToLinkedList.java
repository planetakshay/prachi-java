package practice2023.tree;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }
    private TreeNode flattenTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            return node;
        }
        TreeNode left = flattenTree(node.left);
        TreeNode right = flattenTree(node.right);
        if (left != null) {
            left.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        return right == null ? left : right;
    }
}