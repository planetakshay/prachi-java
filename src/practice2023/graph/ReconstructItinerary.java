package practice2023.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 */
public class ReconstructItinerary {
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