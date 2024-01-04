package practice2023.binarysearch;

/**
 * https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
 *
 * InterviewKickstart BinarySearch material.
 */
public class MajorityElement {
    public boolean isMajorityElement(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if(start == nums.length || nums[start] != target) {
            return false;
        }
        int first = start;
        end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if((end - first + 1) > (nums.length / 2)) {
            return true;
        }
        return false;
    }

    public boolean isMajorityElementOnePass(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if(start == nums.length || nums[start] != target) {
            return false;
        }
        // There should be atleast len/2 + 1 occurrences of majority element
        // and hence at index = start + len / 2 the element should match the
        // target number.
        int index = start + nums.length / 2;
        return  index <= nums.length - 1 && nums[index] == target;
    }
}
