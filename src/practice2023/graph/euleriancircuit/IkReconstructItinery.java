package practice2023.graph.euleriancircuit;

import java.io.StringBufferInputStream;
import java.util.*;

public class IkReconstructItinery {

    // A queue like data structure is used as in this directed graph
    // We use Hierholzer's algorithm to find the Eulerian Path.
    // In which visited nodes are not preserved instead each edge
    // is removed/bridge is burnt once visited.
    // And a queue makes it easier to poll the vertex as it is visited.

    Map<String, Queue<String>> adjMap;
    List<String> iti;
    public List<String> findItinerary(List<List<String>> tickets, String start) {
        iti = new ArrayList<>();
        adjMap = new HashMap<>();
        for(List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            adjMap.putIfAbsent(src, new PriorityQueue<>());
            adjMap.get(src).add(dest);
        }
        dfs(start);
        // The Eulerian path built will be in the reverse order
        // i.e. from destination to src and hence reverse
        // the result before returning.
        Collections.reverse(iti);
        return iti;
    }

    private void dfs(String vertex) {
        Queue<String> neis = adjMap.get(vertex);
        while(!neis.isEmpty()) {
            dfs(neis.poll());
        }
        iti.add(vertex);
    }
}