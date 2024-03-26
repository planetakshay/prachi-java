package practice2023.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-provinces
 */
public class NumberOfProvinces {
    Set<Integer> visited = new HashSet<>();

    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        int components = 0;
        for (int i = 0; i < cities; i++) {
            if (!visited.contains(i)) {
                components++;
                dfs(i, isConnected);
            }
        }
        return components;
    }

    private void dfs(int vertex, int[][] isConnected) {
        visited.add(vertex);
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[vertex][i] == 1 && !visited.contains(i)) {
                dfs(i, isConnected);
            }
        }
    }
}