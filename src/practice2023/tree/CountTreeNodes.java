package practice2023.tree;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 * Included in Top 150 interview questions in Leetcode.
 */
public class CountTreeNodes {
    /**
     * Following solution is a O(N) solution.
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        return root != null ? 1 + countNodes(root.left) + countNodes(root.right) : 0;
    }

    public int countNodesOptimal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = getDepth(root);
        if (depth == 0) {
            return 1;
        }

        int start = 1;
        int end = (int) Math.pow(2, depth) - 1;
        int mid = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nodeFound(mid, depth, root)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int) Math.pow(2, depth) - 1 + start;
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node.left != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }

    private boolean nodeFound(int index, int depth, TreeNode node) {
        int start = 0;
        int end = (int) Math.pow(2, depth) - 1;
        int mid;

        for (int i = 0; i < depth; i++) {
            mid = start + (end - start) / 2;
            if (index <= mid) {
                node = node.left;
                end = mid;
            } else {
                node = node.right;
                start = mid + 1;
            }
        }
        return node != null;
    }
}