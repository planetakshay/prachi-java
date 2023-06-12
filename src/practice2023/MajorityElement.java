package practice2023;

/**
 * https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * Solution uses Moore's voting algorithm and runs in O(N) time and O(1) space complexity
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        System.out.println("Majority Element 1: " + findMajorityElement(nums));

        nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority Element 2: " + findMajorityElement(nums));

        nums = new int[]{1, 1, 1, 1, 2, 2, 2, 2};
        System.out.println("Majority Element 3: " + findMajorityElement(nums));
    }

    public static int findMajorityElement(int[] nums) {
        int majority = -1;
        if (nums == null || nums.length < 1) {
            return majority;
        }
        // Start by assuming the very first element
        // in the array is the majority element.

        majority = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majority = nums[i];
                count = 1;
            }
        }

        // Now find appearances of majority element and
        // validate if majority is appearing in the array
        // for more than half of the times.
        count = 0;
        for (int num : nums) {
            if (num == majority) {
                count++;
            }
        }

        if (count > ((nums.length) / 2)) {
            return majority;
        } else {
            return -1;
        }
    }
}
