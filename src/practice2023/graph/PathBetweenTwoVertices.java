package practice2023.graph;

import java.util.*;

/**
 * Crowdstrike onsite interview.
 */
public class PathBetweenTwoVertices {
    List<Set<Integer>> adjList;
    boolean[] visited;
    public static void main(String[] args) {
        PathBetweenTwoVertices graph = new PathBetweenTwoVertices();
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 1}, {5, 6}};
        graph.populateGraph(7, edges);
        System.out.println("path between 0 and 1 " + graph.findPath(0, 1));
        System.out.println("path between 1 and 2 " + graph.findPath(1, 2));
        System.out.println("path between 2 and 3 " + graph.findPath(2, 3));
        System.out.println("path between 3 and 4 " + graph.findPath(3, 4));
        System.out.println("path between 4 and 1 " + graph.findPath(4, 1));
        System.out.println("path between 5 and 6 " + graph.findPath(5, 6));
        System.out.println("path between 1 and 6 " + graph.findPath(1, 6));
        System.out.println("path between 1 and 5 " + graph.findPath(1, 5));
        System.out.println("path between 5 and 4 " + graph.findPath(4, 5));
        System.out.println("path between 6 and 3 " + graph.findPath(6, 3));
    }
    public void populateGraph(int noOfVertices, int[][] edges) {
        if (edges != null && edges.length > 0) {
            adjList = new ArrayList<>();
            visited = new boolean[noOfVertices];
            for (int i = 0; i < noOfVertices; i++) {
                adjList.add(new HashSet<>());
            }
            // Directed graph. No bidirectional edges.
            for (int[] edge : edges) {
                adjList.get(edge[0]).add(edge[1]);
            }
        }
    }
    public boolean findPath(int src, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            Set<Integer> neighbours = adjList.get(node);
            if(neighbours.contains(dest)) {
                return true;
            }
            for (int neighbour : neighbours) {
                if (visited[neighbour]) {
                    continue;
                }
                queue.add(neighbour);
                visited[neighbour] = true;
            }
        }
        return false;
    }
}