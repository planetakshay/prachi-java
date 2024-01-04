package practice2023.tree;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * <p>
 * Included in Blind 75
 */
public class MaximumPathSum {
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        sumFromSubtree(root);
        return maxSum;
    }
    private int sumFromSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sumLeft = Math.max(sumFromSubtree(root.left), 0);
        int sumRight = Math.max(sumFromSubtree(root.right), 0);
        maxSum = Math.max(maxSum, sumLeft + sumRight + root.val);
        return Math.max(sumLeft + root.val, sumRight + root.val);
    }
}