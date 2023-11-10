package practice2023.graph;

import java.util.*;

public class LinkedInConnections {

    Map<String, List<String>> connections;

    public static void main(String[] args) {
        String[][] people = new String[][]{{"Prachi", "Swati"}, {"Swati", "Rajashri"}, {"Rajashri", "Adam"}, {"Rajashri", "Daniel"}, {"Prachi", "Sonali"}, {"Daniel", "Donya"}, {"someone", "Unknown"}};
        LinkedInConnections circle = new LinkedInConnections();
        circle.populateGraph(people);
        System.out.println("Prachi and Swati are at level: " + circle.findLevel("Prachi", "Swati"));
        System.out.println("Prachi and Rajashri are at level: " + circle.findLevel("Prachi", "Rajashri"));
        System.out.println("Prachi and Daniel are at level: " + circle.findLevel("Prachi", "Daniel"));
        System.out.println("Prachi and Sonali are at level: " + circle.findLevel("Prachi", "Sonali"));
        System.out.println("Prachi and Donya are at level: " + circle.findLevel("Prachi", "Donya"));
        System.out.println("Prachi and Unknown are at level: " + circle.findLevel("Prachi", "unknown"));
    }
    public void populateGraph(String[][] people) {
        connections = new HashMap<>();
        for (String[] connection : people) {
            List<String> friends = connections.getOrDefault(connection[0], new ArrayList<>());
            friends.add(connection[1]);
            connections.put(connection[0], friends);
        }
    }
    public int findLevel(String person, String friend) {
        Map<String, Boolean> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(person);
        visited.put(person, true);
        int level = 1;
        while (!queue.isEmpty()) {
            String node = queue.poll();
            List<String> neighbours = connections.get(node);
            if(neighbours != null && !neighbours.isEmpty()) {
                for (String neighbour : connections.get(node)) {
                    if (neighbour.equals(friend)) {
                        return level;
                    }
                    if (!visited.containsKey(neighbour)) {
                        queue.offer(neighbour);
                        visited.put(neighbour, true);
                    }
                }
                level++;
            }
        }
        return level;
    }
}