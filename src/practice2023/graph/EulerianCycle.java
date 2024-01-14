package practice2023.graph;

public class EulerianCycle {

    public boolean EulerianCycleExists(int n, int[][] edges) {
        if (edges == null || edges.length == 0) {
            return false;
        }
        //count degree of each vertex from 0 to n-1.
        int[] degree = new int[n];

        /**
         * count in + out degree for each vertex as the graph
         * is undirected.
         */
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        // By Eulerian cycle definition, if there exists a vertex with
        // odd number of edges, then graph doesn't have Eulerian cycle.
        for (int num : degree) {
            if (num % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
