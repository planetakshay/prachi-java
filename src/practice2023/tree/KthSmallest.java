package practice2023.tree;

import java.util.Stack;

public class KthSmallest {
    int gk;
    int gValue = 0;

    public int kthSmallest(TreeNode root, int k) {
        gk = k;
        gValue = 0;
        if (root == null) {
            return 0;
        }
        inorderTraversal(root);
        return gValue;
    }

    public void inorderTraversal(TreeNode root) {
        if (gk <= 0) {
            return;
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        gk--;
        if (gk == 0) {
            gValue = root.val;
        }
        if (root.right != null) {
            inorderTraversal(root.right);
        }
    }

    public int kThSmallestIterative(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            node = node.right;
        }
        return node.val;
    }
}