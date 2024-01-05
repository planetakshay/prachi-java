package practice2023.tree;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class LevelOrderBottomUp {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);

        while (!bfs.isEmpty()) {
            List<Integer> levelData = new ArrayList<>();
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = bfs.poll();
                levelData.add(curr.val);
                if (curr.left != null) {
                    bfs.offer(curr.left);
                }
                if (curr.right != null) {
                    bfs.offer(curr.right);
                }
            }
            if (!levelData.isEmpty()) {
                ans.add(levelData);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}