package practice2023.tree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/description/
 */
class Height {
    int height;
    boolean balanced;
    public Height(int height, boolean balanced) {
        this.height = height;
        this.balanced = balanced;
    }
}

public class BalancedBinaryTree {
    private Height dfs(TreeNode node) {
        if (node == null) {
            return new Height(-1, true);
        }
        Height left = dfs(node.left);
        if (!left.balanced) {
            return new Height(-1, false);
        }
        Height right = dfs(node.right);
        if (!right.balanced) {
            return new Height(-1, false);
        }
        if (Math.abs(left.height - right.height) < 2) {
            return new Height(Math.max(left.height, right.height) + 1, true);
        }
        return new Height(-1, false);
    }
    public boolean isBalancedBottomUp(TreeNode root) {
        return dfs(root).balanced;
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}