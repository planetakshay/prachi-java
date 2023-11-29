package practice2023.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/clone-graph/
 *
 * Part of Blind 75 problems.
 */
public class CloneGraph {
    private final Map<Node, Node> cloneMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        //construct a map of node and its clone.
        if (node == null) {
            return null;
        }
        if (cloneMap.containsKey(node)) {
            // return clone.
            return cloneMap.get(node);
        }
        Node cloned = new Node(node.val);
        cloneMap.put(node, cloned);
        for (Node neigh : node.neighbors) {
            cloned.neighbors.add(cloneGraph(neigh));
        }
        return cloned;
    }

    public Node cloneGraphIterative(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>(List.of(node));
        Map<Node, Node> cloneMap = new HashMap<>();
        cloneMap.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (Node neigh : temp.neighbors) {
                if (!cloneMap.containsKey(neigh)) {
                    cloneMap.put(neigh, new Node(neigh.val));
                    queue.offer(neigh);
                }
                cloneMap.get(temp).neighbors.add(cloneMap.get(neigh));
            }
        }
        return cloneMap.get(node);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}