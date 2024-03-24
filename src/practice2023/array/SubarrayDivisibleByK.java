package practice2023.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 */
public class SubarrayDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> sumToFreq = new HashMap<>();
        sumToFreq.put(0, 1);
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            sum = sum % k;
            if (sum < 0) {
                sum += k;
            }
            if (sumToFreq.containsKey(sum % k)) {
                count += sumToFreq.get(sum);
                sumToFreq.put(sum, sumToFreq.get(sum) + 1);
            } else {
                sumToFreq.put(sum, 1);
            }
        }
        return count;
    }
}