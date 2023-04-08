package practice2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Two Sum. Find a pair of integer from the array that
 * adds up to the input integer.
 */

class TwoSum {
    public static int[] bruteForce(int[] nums, int target) {
        int indices[] = new int[2];
        int length = nums.length;
        if (length > 1) {
            for (int i = 0; i < length; i++) {
                for (int j = 1; j < length; j++) {
                    if (i != j && nums[i] + nums[j] == target) {
                        indices[0] = i;
                        indices[1] = j;
                        return indices;
                    }
                }
            }
        }
        return indices;
    }

    public static int[] efficient(int[] nums, int target) {

        Map<Integer, Integer> diffMap = new HashMap<>();
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if (diffMap.containsKey(diff)) {
                return new int[]{diffMap.get(diff), i};
            }
            diffMap.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    public static void display(int[] indices) {
        StringJoiner answer = new StringJoiner(",");
        Arrays.stream(indices).mapToObj(String::valueOf).forEach(answer::add);
        System.out.println("[" + answer.toString() + "]");
    }


    public static void main(String args[]) {
        int[] indices = TwoSum.bruteForce(new int[]{2, 5, 5, 3}, 10);
        display(indices);

        indices = TwoSum.efficient(new int[]{2, 5, 5, 3}, 10);
        display(indices);
    }
}