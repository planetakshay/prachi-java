package practice2023.array;

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 */
public class MaximumConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int i = 0, j = 0;
        int count = 0;

        while (j < len) {
            if (nums[j] == 0) {
                count++;
            }
            j++;
            if (count > k) {
                if (nums[i] == 0) {
                    count--;
                }
                i++;
            }
        }
        return j - i;
    }
}
