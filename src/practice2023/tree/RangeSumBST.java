package practice2023.tree;

public class RangeSumBST {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    private void dfs(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }
        if (node.val >= low && node.val <= high) {
            sum += node.val;
        }
        // Since this is a binary search tree, traverse left
        // only when node value is higher than low
        if (low < node.val) {
            dfs(node.left, low, high);
        }
        // Since this is a binary search tree, traverse right
        // only when node value is lowerx1 than low
        if (node.val < high) {
            dfs(node.right, low, high);
        }
    }
}
