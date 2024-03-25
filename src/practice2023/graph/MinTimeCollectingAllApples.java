package practice2023.graph;

import java.util.*;

public class MinTimeCollectingAllApples {
    Set<Integer> visited;
    Map<Integer, List<Integer>> graph;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        visited = new HashSet<>();
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
        return dfs(0, 0, hasApple);
    }
    private int dfs(int node, int cost, List<Boolean> hasApple) {
        if (visited.contains(node)) {
            return 0;
        }
        visited.add(node);
        int childrenCost = 0;
        for (int curr : graph.get(node)) {
            childrenCost += dfs(curr, 2, hasApple);
        }
        if (childrenCost == 0 && !hasApple.get(node)) {
            return 0;
        }
        return childrenCost + cost;
    }
}