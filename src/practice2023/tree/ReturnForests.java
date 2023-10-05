package practice2023.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/delete-nodes-and-return-forest/submissions/
 *
 */
public class ReturnForests {
    Set<Integer> toBeDeletedNodes = new HashSet<>();
    List<TreeNode> remainingNodes = new LinkedList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        for(int i : toDelete) {
            toBeDeletedNodes.add(i);
        }
        helper(root);
        // Add root at the last if it is not part of the deleted list.
        if(!toBeDeletedNodes.contains(root.val)) {
            remainingNodes.add(root);
        }
        return remainingNodes;
    }

    public TreeNode helper(TreeNode node) {
        if(node == null) {
            return null;
        }
        node.left = helper(node.left);
        node.right = helper(node.right);
        if(toBeDeletedNodes.contains(node.val)) {
            if(node.left != null) {
                remainingNodes.add(node.left);
            }
            if(node.right != null) {
                remainingNodes.add(node.right);
            }
            // leaf node
            return null;
        }
        return node;
    }
}
