package practice2023.tree;

public class LowestCommonAncestorOfBT {
    private TreeNode ancestor;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findAncestor(root, p, q);
        return ancestor;
    }
    private boolean findAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        int left = findAncestor(node.left, p, q) ? 1 : 0;
        int right = findAncestor(node.right, p, q) ? 1 : 0;
        int mid = (node == p || node == q) ? 1 : 0;
        int total = mid + left + right;
        if (total >= 2) {
            ancestor = node;
        }
        return (total > 0);
    }
}