package practice2023;

import com.sun.source.tree.Tree;

import java.util.Stack;

/**
 * https://leetcode.com/problems/path-sum/
 * https://www.educative.io/blog/google-coding-interview-questions
 *
 * Definition for a binary tree node.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }

        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> sum = new Stack<>();

        nodes.push(root);
        sum.push(targetSum - root.val);

        while(!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int sumSoFar = sum.pop();
            if(node.left == null && node.right == null && sumSoFar == 0) {
                return true;
            }
            if(node.left != null) {
                nodes.push(node.left);
                sum.push(sumSoFar - node.left.val);
            }
            if(node.right != null) {
                nodes.push(node.right);
                sum.push(sumSoFar - node.right.val);
            }
        }
        return false;
    }
}