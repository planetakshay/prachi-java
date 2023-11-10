package practice2023.tree;

/**
 * Covered in IK live class for trees.
 */
public class BinaryTreeDiameter {
    static int diameter;
    static Integer binary_tree_diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return diameter;
    }
    static int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int currDiameter = 0;
        int leftHeight = 0;
        int rightHeight = 0;

        if (root.left != null) {
            leftHeight = dfs(root.left);
            currDiameter += leftHeight + 1;
        }
        if (root.right != null) {
            rightHeight = dfs(root.right);
            currDiameter += rightHeight + 1;
        }
        diameter = Math.max(diameter, currDiameter);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}