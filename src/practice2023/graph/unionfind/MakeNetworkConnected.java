package practice2023.graph.unionfind;

/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
 */
public class MakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        UnionFind union = new UnionFind(n);
        int connected = n;

        for (int[] conn : connections) {
            int node1 = conn[0];
            int node2 = conn[1];
            if (union.find(node1) != union.find(node2)) {
                connected--;
                union.union(node1, node2);
            }
        }
        return connected - 1;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
        rank = new int[size];
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xset = find(x);
        int yset = find(y);
        if (xset == yset) {
        } else if (rank[xset] < rank[yset]) {
            parent[xset] = yset;
        } else if (rank[xset] > rank[yset]) {
            parent[yset] = xset;
        } else {
            parent[yset] = xset;
            rank[xset]++;
        }
    }
}