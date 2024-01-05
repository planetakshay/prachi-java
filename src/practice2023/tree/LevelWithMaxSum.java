package practice2023.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 */
public class LevelWithMaxSum {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int levelWithMaxSum = level;
        int maxSum = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            level++;
            if (sum > maxSum) {
                maxSum = sum;
                levelWithMaxSum = level;
            }
        }
        return levelWithMaxSum;
    }
}