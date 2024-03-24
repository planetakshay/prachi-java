package practice2023.graph.unionfind;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind unionFind = new UnionFind(m * n);
        List<Integer> ans = new ArrayList<>();

        for (int[] pos : positions) {
            int currPos = pos[0] * n + pos[1];
            unionFind.addLand(currPos);

            for (int i = 0; i < directions.length; i++) {
                int neiX = pos[0] + directions[i][0];
                int neiY = pos[1] + directions[i][1];
                int neiPos = neiX * n + neiY;

                if (neiX >= 0 && neiX < m && neiY >= 0 && neiY < n && unionFind.isLand(neiPos)) {
                    unionFind.union(currPos, neiPos);
                }
            }
            ans.add(unionFind.totalIslands());
        }
        return ans;
    }

    class UnionFind {
        int[] parent;
        int[] rank;
        int count;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = -1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int xP = find(x);
            int yP = find(y);
            if (xP == yP) {
                return;
            } else if (rank[xP] < rank[yP]) {
                parent[xP] = yP;
            } else if (rank[xP] > rank[yP]) {
                parent[yP] = xP;
            } else {
                parent[yP] = xP;
                rank[xP]++;
            }
            count--;
        }

        public void addLand(int x) {
            if (parent[x] >= 0) {
                return;
            }
            parent[x] = x;
            count++;
        }

        public boolean isLand(int x) {
            return parent[x] >= 0;
        }

        public int totalIslands() {
            return count;
        }
    }
}