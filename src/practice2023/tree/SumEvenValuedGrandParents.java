package practice2023.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 */
public class SumEvenValuedGrandParents {
    private int getValue(TreeNode node) {
        return node == null ? 0 : node.val;
    }
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val % 2 == 0) {
                if (node.left != null) {
                    sum += getValue(node.left.left) + getValue(node.left.right);
                }
                if (node.right != null) {
                    sum += getValue(node.right.left) + getValue(node.right.right);
                }
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return sum;
    }
}