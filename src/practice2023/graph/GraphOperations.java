package practice2023.graph;

import java.util.*;

public class GraphOperations {
 /*   enum Visit {
        VISITED("Visited"),
        UNVISITED("Unvisited"),
        VISITING("Visiting");
        String state;
        Visit(String state) {
            this.state = state;
        }
    }

    Graph createGraph() {
        Map<Vertex, List<Vertex>> adjacencyList = new HashMap<>();
        Graph graph = new Graph(adjacencyList);
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }
    public static void main (String[] args) {
        GraphOperations graphOperations = new GraphOperations();
        Graph graph = graphOperations.createGraph();
        Set<String> nodes = graphOperations.depthFirstSearch(graph, "Bob");
        nodes.stream().forEach(s -> System.out.print("\t" + s));
    } */
    /**
     * Uses BFS as it is recommended for determining shortest path
     * between two vertices.
     * @param g
     * @param src
     * @param dest
     * @return
     *
     * Comparison between BFS and DFS for graphs is explained here
     * https://www.geeksforgeeks.org/difference-between-bfs-and-dfs/
     *
     */

    /*
    public static boolean hasPath(Graph g, Vertex src, Vertex dest, boolean[] visited) {
        if(src == dest) {
            return true;
        }
        return false;
    }

    Set<String> depthFirstSearch(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            String vertex = stack.pop();
            if(!visited.contains(vertex)) {
                visited.add(vertex);
                for(Vertex v : graph.getAdjVertices(vertex)) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    } */
}
/*
class Vertex {
    String label;

    Vertex(String label) {
        this.label = label;
    }
}

class Edge {
    int src, dest;
    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

class Graph {
    private Map<Vertex, List<Vertex>> adjacencyList;

    public Graph(Map<Vertex, List<Vertex>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    void addVertex(String label) {
        adjacencyList.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjacencyList.values().stream().forEach(e -> e.remove(v));
        adjacencyList.remove(new Vertex(label));
    }

    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
    }

    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjacencyList.get(v1);
        List<Vertex> eV2 = adjacencyList.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    List<Vertex> getAdjVertices(String label) {
        return adjacencyList.get(new Vertex(label));
    }
}
 */