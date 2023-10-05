package practice2023.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contiguous-array/description/
 */
public class BinaryContinuousSubarray {

    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        Map<Integer, Integer> countToIndex = new HashMap<>();
        countToIndex.put(0, -1);
        int count = 0, maxLen = 0;
        for (int i = 0; i < len; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (countToIndex.containsKey(count)) {
                // i - countToIndex will give a new length, and we
                // need to get the max of prev maxLen and the current.
                maxLen = Math.max(maxLen, i - countToIndex.get(count));
            } else {
                countToIndex.put(count, i);
            }
        }
        return maxLen;
    }
}