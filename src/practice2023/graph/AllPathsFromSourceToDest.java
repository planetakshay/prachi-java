package practice2023.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */
public class AllPathsFromSourceToDest {
    List<List<Integer>> paths;
    List<Integer> curr;

    public static void main(String[] args) {
        AllPathsFromSourceToDest sourceToDest = new AllPathsFromSourceToDest();

        int[][] graph = new int[][]{{1,2},{3},{3},{}};
        System.out.println(sourceToDest.allPathsSourceTarget(graph));
        graph = new int[][]{{4,3,1},{3,2,4},{3},{4}, {}};
        System.out.println(sourceToDest.allPathsSourceTarget(graph));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        paths = new ArrayList<>();
        curr = new ArrayList<>();
        curr.add(0);
        dfs(0, graph.length - 1, graph);
        return paths;
    }
    private void dfs(int src, int dest, int[][] graph) {
        if(src == dest) {
            paths.add(new ArrayList<>(curr));
        }
        for(int neighbour : graph[src]) {
            curr.add(neighbour);
            dfs(neighbour, dest, graph);
            curr.remove(curr.size() - 1);
        }
    }
}