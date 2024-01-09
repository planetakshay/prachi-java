package practice2023.tree;

/**
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * <p>
 * This is an in-place in-order traversal of a Binary Search tree
 * where last and first nodes are marked and linked to convert it to
 * circular doubly linked list.
 * InOrder traversal is used when we want to get the nodes of the
 * tree in sorted order.
 */
public class TreeToDoublyLinkedList {
    TreeNode first = null;
    TreeNode last = null;
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        last.right = first;
        first.left = last;
        return first;
    }
    private void dfs(TreeNode node) {
        if (node != null) {
            dfs(node.left);
            if (last != null) {
                last.right = node;
                node.left = last;
            } else {
                first = node;
            }
            last = node;
            dfs(node.right);
        }
    }
}