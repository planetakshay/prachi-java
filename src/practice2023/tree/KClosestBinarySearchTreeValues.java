package practice2023.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/closest-binary-search-tree-value-ii/description/
 */
public class KClosestBinarySearchTreeValues {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> arr = new ArrayList<>();
        dfs(root, arr);
        int left = 0;
        int right = arr.size() - k;

        while (left < right) {
            int mid = (right + left) / 2;
            if (Math.abs(target - arr.get(mid + k)) < Math.abs(target - arr.get(mid))) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr.subList(left, left + k);
    }

    private void dfs(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        dfs(node.left, arr);
        arr.add(node.val);
        dfs(node.right, arr);
    }
}