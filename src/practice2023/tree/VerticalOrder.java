package practice2023.tree;
import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 */
public class VerticalOrder {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Map<Integer, List> columns = new HashMap<>();
        Queue<NodeToValue> queue = new LinkedList<>();
        int col = 0;
        queue.offer(new NodeToValue(root, col));
        while (!queue.isEmpty()) {
            NodeToValue pair = queue.poll();

            root = pair.node;
            col = pair.val;

            if (root != null) {
                List<Integer> temp = columns.getOrDefault(col, new ArrayList<>());
                temp.add(root.val);
                columns.put(col, temp);

                queue.offer(new NodeToValue(root.left, col - 1));
                queue.offer(new NodeToValue(root.right, col + 1));
            }
        }
        List<Integer> sorted = new ArrayList<>(columns.keySet());
        Collections.sort(sorted);

        for (int num : sorted) {
            ans.add(columns.get(num));
        }
        return ans;
    }
}
class NodeToValue {
    TreeNode node;
    Integer val;

    public NodeToValue(TreeNode node, Integer val) {
        this.node = node;
        this.val = val;
    }
}