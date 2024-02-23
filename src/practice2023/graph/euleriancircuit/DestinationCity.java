package practice2023.graph.euleriancircuit;

import java.util.*;

public class DestinationCity {
    Map<String, Queue<String>> adjMap;
    List<String> cities;
    public static void main(String[] args) {
        List<List<String>> paths = List.of(List.of("London", "New York"), List.of("New York", "Lima"), List.of("Lima", "Sao Paulo"));
        DestinationCity destinationCity = new DestinationCity();
        System.out.println("Destination City: " + destinationCity.destCity(paths));
    }
    public String destCity(List<List<String>> paths) {
        adjMap = new HashMap<>();
        cities = new ArrayList<>();
        for (List<String> path : paths) {
            String src = path.get(0);
            String dest = path.get(1);
            adjMap.putIfAbsent(src, new PriorityQueue<>());
            adjMap.get(src).add(dest);
        }
        dfs(paths.get(0).get(0));
        return cities.get(0);
    }
    private void dfs(String city) {
        Queue<String> neighbours = adjMap.get(city);
        while (neighbours != null && !neighbours.isEmpty()) {
            dfs(neighbours.poll());
        }
        cities.add(city);
    }
}