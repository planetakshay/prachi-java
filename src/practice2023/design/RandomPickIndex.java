package practice2023.design;

import java.util.*;

public class RandomPickIndex {
    Map<Integer, List<Integer>> numToIndices;
    Random random;

    public RandomPickIndex(int[] nums) {
        random = new Random();
        numToIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indices = numToIndices.getOrDefault(nums[i], new ArrayList<>());
            indices.add(i);
            numToIndices.put(nums[i], indices);
        }
    }

    public int pick(int target) {
        if (numToIndices.containsKey(target)) {
            List<Integer> found = numToIndices.get(target);
            int index = random.nextInt(found.size());
            return found.get(index);
        }
        return -1;
    }
}