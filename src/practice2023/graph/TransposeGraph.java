package practice2023.graph;

import java.util.*;

/**
 * Covered in IK timed tests for Graphs
 * Interview Kickstart.
 */
public class TransposeGraph {
    Map<GraphNode, GraphNode> map;

    public GraphNode transpose(GraphNode node) {
        map = new HashMap<>();
        return dfs(node);
    }

    public GraphNode dfs(GraphNode node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        map.put(node, new GraphNode(node.value));
        for (GraphNode nei : node.neighbors) {
            GraphNode newNei = dfs(nei);
            GraphNode newSrc = map.get(node);
            newNei.neighbors.add(newSrc);
        }
        return map.get(node);
    }

    public GraphNode bfs(GraphNode src) {
        Set<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();
        visited.add(src);
        queue.add(src);
        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();
            if (!map.containsKey(node)) {
                GraphNode newNode = new GraphNode(node.value);
                map.put(node, newNode);
            }
            for (GraphNode nei : node.neighbors) {
                if (!visited.contains(nei)) {
                    if (map.containsKey(nei)) {
                        GraphNode newNei = new GraphNode(nei.value);
                        map.put(nei, newNei);
                    }
                    visited.add(nei);
                    queue.offer(nei);
                }
                map.get(nei).neighbors.add(map.get(node));
            }
        }
        return map.get(src);
    }
}

class GraphNode {
    int value;
    List<GraphNode> neighbors;

    public GraphNode(int value) {
        this.value = value;
    }
}