package practice2023.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/cousins-in-binary-tree/submissions/
 */
public class Cousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean siblings = false;
            boolean cousins = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr == null) {
                    siblings = false;
                } else {
                    if (curr.val == x || curr.val == y) {
                        if (!cousins) {
                            siblings = true;
                            cousins = true;
                        } else {
                            return !siblings;
                        }
                    }
                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }
                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                    queue.add(null);
                }
            }
            if (cousins) {
                return false;
            }
        }
        return false;
    }
}