package practice2023.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/description/
 */
public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : arr) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        Set<Integer> unique = new HashSet<>(occurrences.values());
        return occurrences.values().size() == unique.size();
    }
}
