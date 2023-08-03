package practice2023.graph;

import java.util.*;

public class GraphOperations1 {

    public static void main(String[] args) {
        int noOfVertices = 5;
        List<List<Integer>> adj = new ArrayList<>(noOfVertices);
        for (int i = 0; i < noOfVertices; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        printGraph(adj);
        System.out.println("Path Between 0 and 3 exists: " + hasPath(adj, 0,3));
        System.out.println("Path Between 0 and 6 exists: " + hasPath(adj, 0,6));


    }

    public static void addEdge(List<List<Integer>> adj, int v, int u) {
        adj.get(v).add(u);
        adj.get(u).add(v);
    }

    public static void printGraph(List<List<Integer>> adj) {
        // For each vertices.
        int noOfVertices = adj.size();
        for (int i = 0; i < noOfVertices - 1; i++) {
            System.out.println("Vertices adjacent to vertex: " + i);
            int noOfNeighbours = adj.get(i).size();
            List<Integer> neighbours = adj.get(i);
            for (int j = 0; j < noOfNeighbours; j++) {
                System.out.print("\t" + neighbours.get(j));
            }
            System.out.println();
        }
    }

    public static boolean hasPath(List<List<Integer>> adj, int v, int u) {
        if (v == u) {
            return true;
        }
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;

        while (!stack.isEmpty()) {
            int a = stack.pop();
            if (!visited[a]) {
                System.out.print("\t" + v);
            }
            List<Integer> neighbours = adj.get(a);
            for (int i = 0; i < neighbours.size(); i++) {
                if (neighbours.get(i) == u) {
                    return true;
                }
                if (!visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
        return false;
    }

    public static void topologicalSort(List<List<Integer>> adj, int v) {

    }
}