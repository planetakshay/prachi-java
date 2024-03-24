package practice2023.tree;

public class LongestConsecutiveSequence {
    int max = 0;

    public int longestConsecutive(TreeNode root) {
        dfsBottomUp(root);
        return max;
    }

    /**
     * Bottom up is similar to Post order traversal.
     *
     * @param node
     * @return
     */
    private int dfsBottomUp(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfsBottomUp(node.left) + 1;
        int right = dfsBottomUp(node.right) + 1;
        if (node.left != null && node.left.val - node.val != 1) {
            left = 1;
        }
        if (node.right != null && node.right.val - node.val != 1) {
            right = 1;
        }
        int len = Math.max(left, right);
        max = Math.max(max, len);
        return len;
    }

    /**
     * TopDown approach will use in-order traversal.
     *
     * @param node
     * @return
     */
    private void dfsTopDown(TreeNode node, TreeNode parent, int len) {
        if (node == null) {
            return;
        }
        len = parent != null && node.val - parent.val == 1 ? len + 1 : 1;
        max = Math.max(max, len);
        dfsTopDown(node.left, node, len);
        dfsTopDown(node.right, node, len);
    }
}