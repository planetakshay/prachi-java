package practice2023.graph;

import java.util.*;

/**
 * Apple on-site
 * https://www.careercup.com/question?id=5631096870928384
 *
 * This is a graph problem that can be solved using Dijkstra's Algorithm
 * to find the shortest paths (hops) between source and destination currencies.
 *
 */
public class CurrencyArbitrage {
    int noOfVertices;
    // Adjacency Map
    Map<String, List<Edge>> forexMap;
    // If a Node has been visited.
    Map<String, Boolean> visited;
    Map<String, Double> distance;

    public CurrencyArbitrage(int size) {
        this.noOfVertices = size;
        this.forexMap = new HashMap<>();
        visited = new HashMap<>();
        distance = new HashMap<>();
    }

    public static void main(String[] args) {
        int size = 4;
        CurrencyArbitrage currencyArbitrage = new CurrencyArbitrage(5);
        ForeignExchange rate1 = new ForeignExchange("USD", "CAD", 1.33);
        ForeignExchange rate2 = new ForeignExchange("USD", "EURO", 0.91);
        ForeignExchange rate3 = new ForeignExchange("EURO", "POUND", 0.86);
        ForeignExchange rate4 = new ForeignExchange("USD", "POUND", 0.79);
        ForeignExchange rate5 = new ForeignExchange("POUND", "INR", 105.59);
        List<ForeignExchange> rates = Arrays.asList(rate1, rate2, rate3, rate4, rate5);
        currencyArbitrage.initializeGraph(rates);
        double toInr = currencyArbitrage.findRate("USD", "INR", 100);
        System.out.println(toInr);

        toInr = currencyArbitrage.findRate("USD", "CAD", 100);
        System.out.println(toInr);

        toInr = currencyArbitrage.findRate("USD", "POUND", 100);
        System.out.println(toInr);

        toInr = currencyArbitrage.findRate("POUND", "USD", 100);
        System.out.println(toInr);
    }

    public void initializeGraph(List<ForeignExchange> rates) {
        for (ForeignExchange exc : rates) {
            List<Edge> edges = forexMap.getOrDefault(exc.src, new ArrayList<>());
            edges.add(new Edge(exc.dest, exc.weight));
            forexMap.put(exc.src, edges);
            visited.put(exc.src, false);
            visited.put(exc.dest, false);
            distance.put(exc.src, Double.MAX_VALUE);
            distance.put(exc.dest, Double.MAX_VALUE);
        }
    }

    public double findRate(String src, String dest, double amount) {
        double rate = 0.0;
        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingDouble(e -> e.weight));
        // distance from src to itself if 0.
        distance.put(src, 0.0);
        pq.add(new Edge(src, 0.0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            String curr1 = edge.node;
            if (visited.get(curr1) != null && visited.get(curr1)) {
                continue;
            }
            visited.put(curr1, true);
            if (forexMap.get(curr1) != null) {
                for (Edge neigh : forexMap.get(curr1)) {
                    String curr2 = neigh.node;
                    Double weight = neigh.weight;

                    double currDist =  distance.get(curr1);

                    if (!visited.get(curr2) && currDist + weight < distance.get(curr2)) {
                        distance.put(curr2, currDist + weight);
                        pq.offer(new Edge(curr2, distance.get(curr2)));
                    }
                }
            }
        }
        return distance.get(dest) * amount;
    }
}

class ForeignExchange {
    String src;
    String dest;
    double weight;

    public ForeignExchange(String src, String dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Edge {
    String node;
    Double weight;

    public Edge(String node, Double weight) {
        this.node = node;
        this.weight = weight;
    }
}