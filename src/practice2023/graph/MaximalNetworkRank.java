package practice2023.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/maximal-network-rank/description/
 */
public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int i=0; i < n; i++) {
            adj.put(i, new HashSet<>());
        }
        for(int[] edge : roads) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i < n; i++) {
            for(int j=i + 1;j < n; j++) {
                Set<Integer> iNeighbours = adj.getOrDefault(i, Collections.emptySet());
                Set<Integer> jNeighbours = adj.getOrDefault(j, Collections.emptySet());
                int rankI = iNeighbours.size();
                int rankJ = jNeighbours.size();
                int curr =  rankI + rankJ;
                // Bidirectional graph. checking one is enough.
                if(iNeighbours.contains(j)) {
                    curr--;
                }
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}