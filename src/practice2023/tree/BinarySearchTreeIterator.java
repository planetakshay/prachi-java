package practice2023.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 *
 */
public class BinarySearchTreeIterator {
    List<Integer> nodes;
    int index;

    public BinarySearchTreeIterator(TreeNode root) {
        this.nodes = new ArrayList<>();
        this.index = 0;
        inorderTraversal(root);
    }
    public void inorderTraversal(TreeNode node) {
        if(node == null) {
            return;
        }
        inorderTraversal(node.left);
        nodes.add(node.val);
        inorderTraversal(node.right);
    }
    public int next() {
        return nodes.get(index++);
    }
    public boolean hasNext() {
        return index < nodes.size();
    }
}