package practice2023.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * Walmart contract
 */
public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println("rearrage: " + Arrays.toString(nums));

        nums = new int[]{0, 1, 0, 3, 12};
        moveZeroesSimpler(nums);
        System.out.println("rearrage: " + Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int lastNonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZero++] = nums[i];
            }
        }
        for (int i = lastNonZero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
    public static void moveZeroesSimpler(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int lastNonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[lastNonZero];
                nums[lastNonZero++] = temp;
            }
        }
    }
}