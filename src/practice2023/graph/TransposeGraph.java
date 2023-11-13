package practice2023.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if(map.containsKey(node)) {
            return map.get(node);
        }
        map.put(node, new GraphNode(node.value));
        for(GraphNode nei : node.neighbors) {
            GraphNode newNei = dfs(nei);
            GraphNode newSrc = map.get(node);
            newNei.neighbors.add(newSrc);
        }
        return map.get(node);
    }
}

class GraphNode {
    int value;
    List<GraphNode> neighbors;

    public GraphNode(int value) {
        this.value = value;
    }
}
