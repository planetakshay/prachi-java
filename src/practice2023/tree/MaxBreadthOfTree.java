package practice2023.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 *
 * Interview Kickstart
 */
public class MaxBreadthOfTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<Pair> queue = new LinkedList<>();
        Pair pair = new Pair(root, 0);
        queue.add(pair);
        int maxWidth = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int start = 0, end = 0;
            for(int i=0;i<size;i++) {
                Pair temp = queue.poll();
                TreeNode node = temp.node;
                int index = temp.index;
                if(i == 0) {
                    start = index;
                }
                if(node.left != null) {
                    queue.add(new Pair(node.left, index * 2));
                }
                if(node.right != null) {
                    queue.add(new Pair(node.right, 1 + (index * 2)));
                }
                if(i == size - 1) {
                    end = index;
                }
            }
            int width = end - start + 1;
            maxWidth = Math.max(maxWidth, width);
        }
        return maxWidth;
    }
}
class Pair {
    TreeNode node;
    int index;
    public Pair(TreeNode node, int index) {
        this.index = index;
        this.node = node;
    }
}