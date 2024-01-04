package practice2023.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/possible-bipartition/
 */
public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] bipartition = new int[n + 1];
        Arrays.fill(bipartition, -1);
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            adjList.get(dislike[0]).add(dislike[1]);
            adjList.get(dislike[1]).add(dislike[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (bipartition[i] == -1) {
                Queue<Integer> bfs = new LinkedList<>();
                bfs.add(i);
                bipartition[i] = 0;

                while (!bfs.isEmpty()) {
                    int person = bfs.poll();
                    for (int nei : adjList.get(person)) {
                        if (bipartition[nei] == -1) {
                            bfs.add(nei);
                            bipartition[nei] = 1 - bipartition[person];
                        } else if (bipartition[nei] == bipartition[person]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}