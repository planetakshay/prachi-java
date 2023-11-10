package practice2023.tree;

/**
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/description/
 * <p>
 * Asked by Anthony Hartmann in a IK mock interview for Trees.
 * Interview Kickstart
 */
public class MaxSumBstInBt {
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        getSum(root);
        return maxSum;
    }
    private BstProperties getSum(TreeNode root) {
        if (root == null) {
            return new BstProperties(0, true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        BstProperties leftBst = getSum(root.left);
        BstProperties rightBst = getSum(root.right);
        int min = Math.min(root.val, Math.min(leftBst.min, rightBst.min));
        int max = Math.max(root.val, Math.max(leftBst.max, rightBst.max));
        int sum = root.val + leftBst.sum + rightBst.sum;

        if (root.val <= leftBst.max ||
                root.val >= rightBst.min) {
            return new BstProperties(sum, false, min, max);
        }
        if (leftBst.bst && rightBst.bst) {
            maxSum = Math.max(maxSum, leftBst.sum + rightBst.sum + root.val);
            return new BstProperties(sum, true, min, max);
        }
        return new BstProperties(sum, false, min, max);
    }

    class BstProperties {
        int sum;
        boolean bst;
        int min;
        int max;
        public BstProperties(int sum, boolean bst, int min, int max) {
            this.sum = sum;
            this.bst = bst;
            this.min = min;
            this.max = max;
        }
    }
}