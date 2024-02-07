package practice2023.tree;

import java.util.*;

/**
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
 */
public class InfectedTree {
    Map<Integer, Set<Integer>> map;
    public int amountOfTime(TreeNode root, int start) {
        map = new HashMap<>();
        buildGraphFromTree(root, 0);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        int dis = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                int node = queue.poll();
                for(int num : map.get(node)) {
                    if(!visited.contains(num)) {
                        visited.add(num);
                        queue.add(num);
                    }
                }
                size--;
            }
            dis++;
        }
        return dis - 1;
    }

    /**
     * Need parent because, we need to add parent as a neighbour
     * of the node in the graph.
     *
     * @param node
     * @param parent
     */
    private void buildGraphFromTree(TreeNode node, int parent) {
        if(node == null) {
            return;
        }
        if(!map.containsKey(node.val)) {
            map.put(node.val, new HashSet<>());
        }
        Set<Integer> neis = map.get(node.val);
        if(parent != 0) {
            neis.add(parent);
        }
        if(node.left != null) {
            neis.add(node.left.val);
        }
        if(node.right != null) {
            neis.add(node.right.val);
        }
        buildGraphFromTree(node.left, node.val);
        buildGraphFromTree(node.right, node.val);
    }
}
