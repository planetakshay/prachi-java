package practice2023.graph.euleriancircuit;

import java.util.*;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 *
 * Eulerian Circuit/Cycle/Path
 *
 * Here each ticket can be considered as an edge of an
 * eulerian path. Airports being the vertices.
 */
public class ReconstructItinerary {

    // A queue like data structure is used as in this directed graph
    // We use Hierholzer's algorithm to find the Eulerian Path.
    // In which visited nodes are not preserved instead each edge
    // is removed/bridge is burnt once visited.
    // And a queue makes it easier to poll the vertex as it is visited.

    Map<String, Queue<String>> graph;
    List<String> itinerary;

    public List<String> findItinerary(List<List<String>> tickets) {
        itinerary = new ArrayList<>();
        graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            // Use priorityQueue because we need to return the
            // connecting destinations sorted alphabetically.
            graph.putIfAbsent(src, new PriorityQueue<>());
            graph.get(src).offer(dest);
        }
        dfs("JFK");
        // The Eulerian path built will be in the reverse order
        // i.e. from destination to src and hence reverse
        // the result before returning.
        Collections.reverse(itinerary);
        return itinerary;
    }

    private void dfs(String src) {
        Queue<String> queue = graph.get(src);
        while (queue != null && !queue.isEmpty()) {
            dfs(queue.poll());
        }
        // Use LinkedList and addFirst method instead of List interface
        itinerary.add(src);
    }
}