package practice2023.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathList = new ArrayList<>();
        List<Integer> nodes = new ArrayList<>();
        dfs(root, targetSum, nodes, pathList);
        return pathList;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> nodes, List<List<Integer>> pathList) {
        if(node == null) {
            return;
        }
        nodes.add(node.val);
        if(targetSum == node.val && node.left == null && node.right == null) {
            pathList.add(new ArrayList<>(nodes));
        } else {
            targetSum -= node.val;
            dfs(node.left, targetSum, nodes, pathList);
            dfs(node.right, targetSum, nodes, pathList);
        }
        nodes.remove(nodes.size() - 1);
    }
}