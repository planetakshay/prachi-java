package practice2023.tree;

public class RootToLeafPathSum {
    static boolean found = false;
    static Boolean path_sum(TreeNode root, Integer k) {
        if (root == null) {
            return false;
        }
        return dfs(root, k);
    }
    static boolean dfs(TreeNode root, Integer target) {
        boolean found = false;
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                return true;
            }
        }
        if (root.left != null) {
            found = dfs(root.left, target - root.val);
        }
        if (root.right != null) {
            found = dfs(root.right, target - root.val);
        }
        return found;
    }
}