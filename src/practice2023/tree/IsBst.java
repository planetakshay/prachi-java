package practice2023.tree;

import java.util.Stack;

/**
 *
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Interview kickstart
 */
public class IsBst {
    static Boolean isBst(TreeNode root) {
        if (root == null) {
            return true;
        }
        int value = root.val;
        if (root.left != null && root.left.val > value) {
            return false;
        }
        if (root.right != null && root.right.val < value) {
            return false;
        }
        boolean left = isBst(root.left);
        boolean right = isBst(root.right);
        return left && right;
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (prev != null && root.val <= prev) {
                return false;
            }
            prev = root.val;
            root = root.right;
        }
        return true;
    }
}