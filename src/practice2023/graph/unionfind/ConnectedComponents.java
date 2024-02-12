package practice2023.graph.unionfind;

/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
 */
public class ConnectedComponents {
    int[] parent;
    int[] rank;
    int components = 0;
    public static void main(String[] args) {
        ConnectedComponents components = new ConnectedComponents();
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        System.out.println("No of connected components in the graph: " + components.countComponents(5, edges));
    }
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        return n - components;
    }
    public int find(int vertex) {
        if (parent[vertex] != vertex) {
            vertex = find(parent[vertex]);
        }
        return parent[vertex];
    }
    public void union(int src, int dest) {
        int pSrc = find(src);
        int pDest = find(dest);
        if (pSrc == pDest) {
            return;
        }
        if (rank[pSrc] > rank[pDest]) {
            parent[pDest] = pSrc;
        } else {
            parent[pSrc] = pDest;
            if (rank[pSrc] == rank[pDest]) {
                rank[pDest]++;
            }
        }
        components++;
    }
}