package practice2023.graph;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/redundant-connection/description/
 */
public class RedundantConnection {

    public static final int MAX_EDGES = 20;

    public static void main(String[] args) {
        RedundantConnection redundantConnection = new RedundantConnection();

        int[][] edges = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        System.out.println("Redundant Connection: " + Arrays.toString(redundantConnection.findRedundantConnection(edges)));

        edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println("Redundant Connection: " + Arrays.toString(redundantConnection.findRedundantConnection(edges)));

        edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        System.out.println("Redundant Connection: " + Arrays.toString(redundantConnection.findRedundantConnection(edges)));

        edges = new int[][]{{2,1},{3,1},{4,2},{1,4}};
        System.out.println("Redundant Connection: " + Arrays.toString(redundantConnection.findRedundantConnection(edges)));
    }

    public int[] findRedundantConnection(int[][] edges) {
        DisjointSetUnion dsu = new DisjointSetUnion(MAX_EDGES + 1);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }
}

class DisjointSetUnion {
    int[] parent;
    int[] rank;

    public DisjointSetUnion(int size) {
        rank = new int[size];
        parent = new int[size];
        // every node is its own parent initially
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    /**
     * find parent of x.
     *
     * @param x
     * @return
     */
    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int xr = find(x);
        int yr = find(y);

        if (xr == yr) {
            return false;
        } else if (rank[xr] < rank[yr]) {
            parent[xr] = yr;
        } else if (rank[yr] < rank[xr]) {
            parent[yr] = xr;
        } else {
            parent[yr] = xr;
            rank[xr]++;
        }
        return true;
    }
}