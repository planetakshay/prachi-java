package practice2023.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * Included in Blind 75.
 */
public class SerializeDeSerialize {
    public String serialize(TreeNode root) {
        return convertToString(root, "");
    }
    public String convertToString(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += root.val + ",";
            str = convertToString(root.left, str);
            str = convertToString(root.right, str);
        }
        return str;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeValues = data.split(",");
        List<String> lists = new LinkedList<>(Arrays.asList(nodeValues));
        return convertToNode(lists);
    }
    private TreeNode convertToNode(List<String> l) {
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        node.left = convertToNode(l);
        node.right = convertToNode(l);
        return node;
    }
}