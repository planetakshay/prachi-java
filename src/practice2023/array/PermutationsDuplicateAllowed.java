package practice2023.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/permutations-ii/
 * <p>
 * covered in IK recursion exercise.
 */
public class PermutationsDuplicateAllowed {
    List<List<Integer>> ans;
    Map<Integer, Integer> freq;
    int len = 0;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        len = nums.length;

        freq = new HashMap<>();
        for (int num : nums) {
            int currFreq = freq.getOrDefault(num, 0);
            freq.put(num, currFreq + 1);
        }
        permutation(new ArrayList<>());
        return ans;
    }

    private void permutation(List<Integer> curr) {
        if (curr.size() == len) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (count == 0) {
                continue;
            }
            curr.add(num);
            freq.put(num, count - 1);
            permutation(curr);
            curr.remove(curr.size() - 1);
            freq.put(num, count);
        }
    }
}