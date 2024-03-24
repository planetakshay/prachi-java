package practice2023.array;

/**
 * https://leetcode.com/problems/maximum-difference-between-increasing-elements/
 */
public class MaxDiffBetIncreasingElements {
    public int maximumDifference(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            maxDiff = Math.max(maxDiff, nums[i] - min);
        }
        return maxDiff > 0 ? maxDiff : -1;
    }
}