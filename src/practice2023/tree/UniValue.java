package practice2023.tree;

/**
 * https://leetcode.com/problems/count-univalue-subtrees/
 *
 * Interview Kickstart
 */
public class UniValue {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) {
            return count;
        }
        isUniValue(root);
        return count;
    }

    private boolean isUniValue(TreeNode root) {
        if(root.left == null && root.right == null) {
            count++;
            return true;
        }
        boolean isUniValue = true;
        if(root.left != null) {
            boolean leftUniValue = isUniValue(root.left);
            if(!leftUniValue || root.val != root.left.val) {
                isUniValue = false;
            }
        }

        if(root.right != null) {
            boolean rightUniValue = isUniValue(root.right);
            if(!rightUniValue || root.val != root.right.val) {
                isUniValue = false;
            }
        }

        if(isUniValue) {
            count++;
        }
        return isUniValue;
    }
}
