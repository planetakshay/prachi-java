package practice2023;

import javax.management.BadAttributeValueExpException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Graph {

    private final int v; // No of vertises.
    private final List<Integer>[] adjList; //Adjacency List

    Graph(int v) {
        this.v = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    void topologicalSortUtil(int v, boolean[] visited, Stack stack) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> iterator = adjList[v].iterator();
        while (iterator.hasNext()) {
            i = iterator.next();
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        stack.push(v);
    }

    void topologicalSort() {
        Stack stack = new Stack();

        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + "\t");
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological sort of the given graph");
        g.topologicalSort();
    }
}
