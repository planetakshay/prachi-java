package practice2023;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {public static void main(String[] args) {
    int[] nums = new int[] {3,2,2,3};
    System.out.println("\nArray after elimination " + removeElement(nums, 3));
}

    public static int removeElement(int[] nums, int val) {

        if(nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        for(int ele : nums) {
            if(ele != val) {
                nums[i++] = ele;
            }
        }

        Arrays.stream(nums).forEach(n -> {
            System.out.print(n);
        });
        return i;
    }
}
