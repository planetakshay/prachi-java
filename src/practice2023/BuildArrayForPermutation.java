package practice2023;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/build-array-from-permutation/
 */
public class BuildArrayForPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{0,2,1,5,3,4};
        System.out.println("Permutation Array: " + Arrays.toString(buildArray(nums)));
    }

    public static int[] buildArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
