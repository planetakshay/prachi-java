package practice2023.graph.unionfind;

/**
 * https://leetcode.com/problems/graph-valid-tree/
 * <p>
 * Interview Kickstart assignment from foundation material
 */
public class GraphIsValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length != n - 1) {
            return false;
        }
        UnionFindNoRank unionFindNoRank = new UnionFindNoRank(n);
        for (int[] edge : edges) {
            if (!unionFindNoRank.union(edge[0], edge[1])) {
                return false;
            }
        }
        return true;
    }
}

class UnionFindNoRank {
    private final int[] parent;

    public UnionFindNoRank(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int vertex) {
        int node = vertex;
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }

    public boolean union(int v1, int v2) {
        int parentV1 = find(v1);
        int parentV2 = find(v2);

        if (parentV1 == parentV2) {
            return false;
        }
        parent[parentV1] = parentV2;
        return true;
    }
}