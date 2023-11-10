package practice2023.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * IK practice problems on Tree
 *
 */
public class ConstructBinaryTree {

    static Map<Integer, Integer> nodeToIndex;
    static int preOrderIndex = 0;

    static TreeNode buildBinarySearchTree(ArrayList<Integer> preorder) {
        ArrayList<Integer> inOrder = (ArrayList) preorder.clone();
        Collections.sort(inOrder);
        int len = inOrder.size();
        nodeToIndex = new HashMap<>();
        for (int i = 0; i < len; i++) {
            nodeToIndex.put(inOrder.get(i), i);
        }
        return helper(preorder, 0, len - 1);
    }

    static TreeNode helper(ArrayList<Integer> preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootValue = preorder.get(preOrderIndex++);
        TreeNode root = new TreeNode(rootValue);
        root.left = helper(preorder, left, nodeToIndex.get(rootValue) - 1);
        root.left = helper(preorder, nodeToIndex.get(rootValue) + 1, right);
        return root;
    }
}
