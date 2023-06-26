package practice2023;

import java.util.Arrays;

public class RotateArrayKTimes {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.print(Arrays.toString(nums));
    }
    public static void rotate(int[] nums, int k) {
        if(nums != null && nums.length != 0) {
            // reverse entire array.
            reverseArray(nums, 0, nums.length - 1);
            // now reverse start till kth element of the array.
            reverseArray(nums, 0, k-1);
            //reverse remaining (n-k) elements.
            reverseArray(nums, k, nums.length-1);
        }
    }

    public static int[] reverseArray(int[] nums, int start, int end) {
        int[] reversedArray = nums;
        while(start < end) {
            int temp = reversedArray[start];
            reversedArray[start++] = reversedArray[end];
            reversedArray[end--] = temp;
        }
        return reversedArray;
    }
}
