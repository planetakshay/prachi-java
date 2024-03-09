package practice2023.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/leaf-similar-trees/description/?envType=study-plan-v2&envId=leetcode-75
 * perform preorder traversals on both tree and
 * compare leaves list of both trees.
 */
public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        preorder(root1, leaves1);
        preorder(root2, leaves2);
        return leaves1.equals(leaves2);
    }
    public void preorder(TreeNode node, List<Integer> leaves) {
        if(node == null) {
            return;
        }
        if(node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }
        preorder(node.left, leaves);
        preorder(node.right, leaves);
    }
}