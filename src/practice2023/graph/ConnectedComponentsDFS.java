package practice2023.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Interview Kickstart assignment from foundation material
 * <p>
 * Count Connected Components In An Undirected Graph
 */
public class ConnectedComponentsDFS {
    static int[] components;
    static List<List<Integer>> adjList;

    public static void main(String[] args) {
        List<List<Integer>> edges = List.of(List.of(0, 1),
                List.of(0, 2),
                List.of(2, 0),
                List.of(2, 2),
                List.of(4, 5),
                List.of(5, 5));
        List<List<Integer>> vertices = verticesInComponents(6, edges);
        System.out.println(vertices);
    }

    static Integer numberOfConnectedComponents(int n, List<List<Integer>> edges) {
        components = new int[n];
        adjList = new ArrayList<>();
        Arrays.fill(components, 0);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            adjList.get(edge.get(0)).add(edge.get(1));
            adjList.get(edge.get(1)).add(edge.get(0));
        }
        int component = 0;
        for (int i = 0; i < n; i++) {
            if (components[i] == 0) {
                component++;
                dfs(i, component);
            }
        }
        return component;
    }

    static void dfs(int vertex, int component) {
        components[vertex] = component;
        for (int nei : adjList.get(vertex)) {
            if (components[nei] == 0) {
                dfs(nei, component);
            }
        }
    }

    public static List<List<Integer>> verticesInComponents(int n, List<List<Integer>> edges) {
        int noOfComponents = numberOfConnectedComponents(n, edges);
        List<List<Integer>> verticesInComponents = new ArrayList<>();
        for (int i = 0; i < noOfComponents; i++) {
            verticesInComponents.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            // components are marked from 1...n and arraylist indices
            // are from 0...n
            verticesInComponents.get(components[i] - 1).add(i);
        }
        return verticesInComponents;
    }
}