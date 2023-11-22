package practice2023.tree;

import java.util.ArrayList;
import java.util.List;

public class LeavesOfBinaryTree {
    private List<List<Integer>> leaves;
    public List<List<Integer>> findLeaves(TreeNode root) {
        this.leaves = new ArrayList<>();
        getHeight(root);
        return this.leaves;
    }
    public int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        if (leaves.size() == height) {
            leaves.add(new ArrayList<>());
        }
        leaves.get(height).add(root.val);
        return height;
    }
}