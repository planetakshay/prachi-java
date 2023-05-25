package practice2023;

import java.util.Arrays;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 0};
        input = new int[] {3, 4, -1, 1};
        System.out.println("First missing positive integer: " + findFirstMissingPositive(input));
    }

    public static int findFirstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }
        for(int i=0;i<len;i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index < len && nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        for(int i=0;i < len;i++) {
            if(nums[i] > 0) {
                return i+1;
            }
        }
        return len + 1;
    }
}
