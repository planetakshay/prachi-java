package practice2023.array;

/**
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class MaximumConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        int j=0;
        int len = nums.length;
        while(j < len) {
            if(nums[j] == 1) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
            j++;
        }
        return Math.max(count, max);
    }
}
