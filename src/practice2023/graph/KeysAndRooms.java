package practice2023.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/keys-and-rooms
 */
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int nodes = rooms.size();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int room = queue.poll();
            visited.add(room);
            for (int next : rooms.get(room)) {
                if (!visited.contains(next)) {
                    queue.add(next);
                }
            }
        }
        return visited.size() == nodes;
    }
}