package practice2023.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 *
 */
public class ModeInBinarySearch {
    List<Integer> sorted;

    public int[] findMode(TreeNode root) {
        sorted = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root);

        int mode = Integer.MIN_VALUE;
        int currFreq = 0;
        int curr = 0;

        for (int num : sorted) {
            if (curr == num) {
                currFreq++;
            } else {
                curr = num;
                currFreq = 1;
            }
            if (currFreq > mode) {
                mode = currFreq;
                res = new ArrayList<>();
            }
            if (currFreq == mode) {
                res.add(num);
            }
        }
        int[] mostFreq = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            mostFreq[i] = res.get(i);
        }
        return mostFreq;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        sorted.add(node.val);
        inorderTraversal(node.right);
    }
}