package practice2023.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Interview Kickstart assignment from foundation material
 * <p>
 * Given an undirected graph, perform a Depth-First Search Traversal on it.
 */
public class DFSTraversal {
    static boolean[] visited; // can use a set instead
    static List<List<Integer>> adjList;
    static List<Integer> ans;

    static List<Integer> dfsTraversal(int n, List<List<Integer>> edges) {
        adjList = new ArrayList<>();
        visited = new boolean[n];
        ans = new ArrayList<>();
        // Build adjacency list of an undirected graph.
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        // Undirected graph
        for (List<Integer> edge : edges) {
            adjList.get(edge.get(0)).add(edge.get(1));
            adjList.get(edge.get(1)).add(edge.get(0));
        }
        // Perform DFS on each UNVISITED vertex of the graph.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                helper(i);
            }
        }
        return ans;
    }

    static void helper(int vertex) {
        visited[vertex] = true;
        ans.add(vertex);
        for (int nei : adjList.get(vertex)) {
            if (!visited[nei]) {
                helper(nei);
            }
        }
    }
}