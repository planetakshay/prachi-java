package practice2023.tree;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int prev = Integer.MAX_VALUE;
            if(level % 2 == 0) {
                prev = Integer.MIN_VALUE;
            }
            for(int i=0; i < size; i++) {
                TreeNode node = queue.poll();
                if((level % 2 == 0 && (node.val % 2 == 0 || node.val <= prev)) || (level % 2 == 1 && (node.val % 2 == 1 || node.val >= prev))) {
                    return false;
                }
                prev = node.val;
                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }
        return true;
    }
}