package practice2023.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Merge two binary search trees.
 * Return root of the merged tree.
 */
public class MergeTwoBSTs {
    static TreeNode merge_two_binary_search_trees(TreeNode root1, TreeNode root2) {
        List<TreeNode> inorder1 = new ArrayList<>();
        List<TreeNode> inorder2 = new ArrayList<>();

        inorder(root1, inorder1);
        inorder(root2, inorder2);

        int size1 = inorder1.size();
        int size2 = inorder2.size();

        List<TreeNode> mergedList = new ArrayList<>(size1 + size2);
        int i=0, j=0;

        while(i < size1 || j < size2) {
            if(i == size1) {
                mergedList.add(inorder2.get(j++));
            } else if(j == size2) {
                mergedList.add(inorder1.get(i++));
            } else {
                if(inorder1.get(i).val < inorder2.get(j).val) {
                    mergedList.add(inorder1.get(i++));
                } else {
                    mergedList.add(inorder2.get(j++));
                }
            }
        }

        for(TreeNode node : mergedList) {
            node.left = null;
            node.right = null;
        }
        return buildMergedTree(mergedList, 0, mergedList.size() - 1);
    }

    private static TreeNode buildMergedTree(List<TreeNode> list, int start, int end) {

        if(start > end) {
            return null;
        }
        if(start == end) {
            return list.get(start);
        }
        int mid = (start + end) / 2;
        list.get(mid).left = buildMergedTree(list, start, mid - 1);
        list.get(mid).right = buildMergedTree(list, mid + 1, end);
        return list.get(mid);
    }

    private static void inorder(TreeNode node, List<TreeNode> inorder) {
        if(node == null) {
            return;
        }
        inorder(node.left, inorder);
        inorder.add(node);
        inorder(node.right, inorder);
    }
}
