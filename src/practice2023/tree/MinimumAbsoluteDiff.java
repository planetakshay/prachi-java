package practice2023.tree;
public class MinimumAbsoluteDiff {
    TreeNode prev;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (prev != null) {
            min = Math.min(min, node.val - prev.val);
        }
        prev = node;
        dfs(node.right);
    }
}