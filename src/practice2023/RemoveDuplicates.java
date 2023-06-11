package practice2023;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * return number of unique elements after eliminating duplicates.
 * Perform operations in-place.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.println("\nUnique elements in the array: " + removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        }

        int j = 1;
        for(int i = 0 ;i<nums.length - 1;i++) {
            if(nums[i] != nums[i+1]) {
                nums[j] = nums[i+1];
                j++;
            }
        }

        Arrays.stream(nums).forEach(n -> {
            System.out.print(n);
        });
        return j;
    }
}