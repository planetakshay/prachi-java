package practice2023;

import java.util.Arrays;

/**
 * Reverse an array in-place. Data type of the array could be anything.
 * For simplicity, we will use an int array.
 *
 */
public class ReverseAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        reverseArray(nums);
        Arrays.stream(nums).forEach(num -> {
            System.out.print(num + "\t");
        });
    }

    public static void reverseArray(int[] nums) {
        if (nums == null || nums.length < 1)
            return;
        int temp = 0;
        int length = nums.length;
        int j = length - 1;
        int i = 0;
        while (i <= (length / 2) && j >= (length / 2)) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}