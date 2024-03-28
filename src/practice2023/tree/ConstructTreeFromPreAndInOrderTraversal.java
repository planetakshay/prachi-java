package practice2023.tree;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
public class ConstructTreeFromPreAndInOrderTraversal {
    int iIndex = 0;
    int pIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int min) {
        if (pIndex >= preorder.length) {
            return null;
        }
        if (inorder[iIndex] == min) {
            iIndex++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pIndex++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, min);
        return node;
    }
}