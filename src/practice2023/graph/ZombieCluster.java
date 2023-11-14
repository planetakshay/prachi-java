package practice2023.graph;

import java.util.ArrayList;

/**
 * Covered in IK graph practice set.
 * <p>
 * Interview Kickstart
 */
public class ZombieCluster {
    static boolean[] visited;
    static Integer zombie_cluster(ArrayList<String> zombies) {
        if (zombies == null || zombies.size() == 0) {
            return 0;
        }
        int noOfZombies = zombies.size();
        int clusters = 0;
        visited = new boolean[noOfZombies];
        for (int i = 0; i < noOfZombies; i++) {
            if (!visited[i]) {
                clusters++;
                dfs(zombies, i, noOfZombies);
            }
        }
        return clusters;
    }
    static void dfs(ArrayList<String> zombies, int index, int size) {
        visited[index] = true;
        for (int i = 0; i < size; i++) {
            if (zombies.get(index).charAt(i) == '1' && !visited[i]) {
                dfs(zombies, i, size);
            }
        }
    }
}