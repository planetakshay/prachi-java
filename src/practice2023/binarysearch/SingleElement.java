package practice2023.binarysearch;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 *
 * Input array is sorted in the ascending order and every element
 * is repeated twice except one element. We need to find and return
 * such element.
 *
 * Since we have all but one element repeating exactly ones and the
 * fact that the array is sorted, single element can only occur at
 * an even index which is not followed by the same element.
 * Given this observation we will only explore even indices to look
 * for a single element, and we will also employ binary search
 */
public class SingleElement {
    public int singleNonDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid % 2 == 1) {
                mid--;
            }
            if(nums[mid] == nums[mid + 1]) {
                start = mid + 2;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}