package practice2023.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/continuous-subarray-sum/
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            if (sum == 0 && i > 0) {
                return true;
            }
            if (sumToIndex.containsKey(sum) && i - sumToIndex.get(sum) > 1) {
                return true;
            }
            if (!sumToIndex.containsKey(sum)) {
                sumToIndex.put(sum, i);
            }
        }
        return false;
    }

    /**
     * Time limit exceeds in Leetcode.
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySumBruteForce(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int len = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                len++;
                if (sum % k == 0 && len >= 2) {
                    count++;
                }
            }
        }
        return count > 0;
    }
}