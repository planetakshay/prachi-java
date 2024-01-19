package practice2023.tree;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * Included in Top 150 interview questions in Leetcode.
 */
public class SumRootToLeaf {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        traverse(root, 0);
        return sum;
    }
    public void traverse(TreeNode node, int val) {
        int curr = val;
        if(node != null) {
            curr = curr * 10 + node.val;
            if(node.left == null && node.right == null) {
                sum += curr;
            }
            traverse(node.left, curr);
            traverse(node.right, curr);
        }
    }
}