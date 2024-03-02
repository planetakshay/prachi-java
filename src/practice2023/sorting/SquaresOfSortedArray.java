package practice2023.sorting;

import java.util.Arrays;

public class SquaresOfSortedArray {

    public static int[] square(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }
        int size = nums.length;
        for(int i=0; i < size; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public static int[] squareEfficient(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }
        int size = nums.length;
        int i=0;
        int j = size - 1;
        int index = size - 1;

        while(i <= j) {
            int iAbs = Math.abs(nums[i]);
            int jAbs = Math.abs(nums[j]);
            if(iAbs > jAbs) {
                nums[index--] = iAbs * iAbs;
                i++;
            } else {
                nums[index--] = jAbs * jAbs;
                j--;
            }
        }
        return nums;
    }
}
