package practice2023.graph;

import java.util.*;

public class DistinctOrderTraversal {

    int nodes;
    int[][] edges;

    List<Queue<Integer>> adjacencyList;

    Queue<Integer> order;

    public DistinctOrderTraversal(int nodes, int[][] edges) {
        this.nodes = nodes;
        this.edges = edges;
        buildAdjacencyList(nodes, edges);
    }

    private void buildAdjacencyList(int nodes, int[][] edges) {
        adjacencyList = new ArrayList<>();
        for(int i=0; i <= nodes; i++) {
            adjacencyList.add(new PriorityQueue<>());
        }
        for(int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            adjacencyList.get(src).add(dest);
            adjacencyList.get(dest).add(src);
        }
    }

    public List<Integer> distinctOrder() {
        order = new PriorityQueue<>(Collections.reverseOrder());;
        for(int i = 1; i <= nodes; i++) {
            dfs(i);
        }
        Set<Integer> orderedList = new LinkedHashSet<>();
        while(!order.isEmpty()) {
            orderedList.add(order.poll());
        }
        return orderedList.stream().toList();
    }

    public void dfs(int src) {
        order.add(src);
        Queue<Integer> neighbours = adjacencyList.get(src);
        while(!neighbours.isEmpty()) {
            dfs(neighbours.poll());
        }
    }

    public static void main(String args[]) {
        int nodes = 5;
        int[][] edges = new int[][]{{4,5}, {5, 1}, {1,4}, {4,3}, {3,2}};
        DistinctOrderTraversal distinctOrderTraversal = new DistinctOrderTraversal(nodes, edges);
        List<Integer> order = distinctOrderTraversal.distinctOrder();
        System.out.println(order);
    }
}
