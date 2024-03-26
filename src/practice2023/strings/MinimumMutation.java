package practice2023.strings;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-genetic-mutation
 */
public class MinimumMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();

        queue.add(startGene);
        seen.add(startGene);

        int mutations = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String curr = queue.poll();
                if (curr.equals(endGene)) {
                    return mutations;
                }
                for (char ch : new char[]{'A', 'C', 'G', 'T'}) {
                    for (int i = 0; i < curr.length(); i++) {
                        String adj = curr.substring(0, i) +
                                ch + curr.substring(i + 1);
                        if (!seen.contains(adj) && List.of(bank).contains(adj)) {
                            queue.add(adj);
                            seen.add(adj);
                        }
                    }
                }
            }
            mutations++;
        }
        return -1;
    }
}