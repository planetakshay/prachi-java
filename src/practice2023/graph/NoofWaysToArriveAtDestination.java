package practice2023.graph;

import java.util.*;

public class NoofWaysToArriveAtDestination {
    List<List<List<Integer>>> adjList;
    int mod = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        adjList = new ArrayList<>();
        for(int i=0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        // Adjacency list with weights.
        for(int[] edge : roads) {
            int src = edge[0];
            int dest = edge[1];
            int time = edge[2];

            adjList.get(src).addAll(List.of(List.of(dest, time)));
            adjList.get(dest).addAll(List.of(List.of(src, time)));
        }
        return shortestPath(0, n);
    }

    private int shortestPath(int src, int dest) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int[] cost = new int[dest];
        Arrays.fill(cost, Integer.MAX_VALUE);

        long[] ways = new long[dest];
        ways[0] = 1;
        cost[0] = 0;

        queue.offer(new int[]{0,0});
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int stop = curr[0];
            int currCost = curr[1];

            if(currCost > cost[stop]) {
                continue;
            }
            for(List<Integer> neighbour : adjList.get(stop)) {
                int nextCity = neighbour.get(0);
                int time = neighbour.get(1);
                if (currCost + time < cost[nextCity]) {
                    cost[nextCity] = currCost + time;
                    queue.offer(new int[]{nextCity, cost[nextCity]});
                    ways[nextCity] = ways[stop];
                } else if (currCost + time == cost[nextCity]) {
                    ways[nextCity] = (ways[nextCity] + ways[stop]) % mod;
                }
            }
        }
        return (int) ways[dest - 1];
    }
}