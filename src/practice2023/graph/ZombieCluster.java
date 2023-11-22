package practice2023.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Covered in IK graph practice set.
 * <p>
 * Interview Kickstart
 */
public class ZombieCluster {
    static boolean[] visited;
    public static void main(String[] args) {
        List<String> zombies = Arrays.asList("1100", "1110", "0110", "0001");
        System.out.println("No of Zombie Clusters: " + zombieCluster(zombies));

        zombies = Arrays.asList("10000", "01000", "00100", "00010", "00001");
        System.out.println("No of Zombie Clusters: " + zombieCluster(zombies));
    }
    static Integer zombieCluster(List<String> zombies) {
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
    static void dfs(List<String> zombies, int index, int size) {
        visited[index] = true;
        for (int i = 0; i < size; i++) {
            if (zombies.get(index).charAt(i) == '1' && !visited[i]) {
                dfs(zombies, i, size);
            }
        }
    }
}