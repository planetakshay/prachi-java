package practice2023.tree;

/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 */
public class Tree2String {
    StringBuilder builder;
    public String tree2str(TreeNode root) {
        builder = new StringBuilder();
        dfs(root);
        return builder.toString();
    }

    public void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        builder.append(node.val);
        if(node.left == null && node.right == null) {
            return;
        }
        builder.append("(");
        dfs(node.left);
        builder.append(")");
        if(node.right != null) {
            builder.append("(");
            dfs(node.right);
            builder.append(")");
        }
    }
}
