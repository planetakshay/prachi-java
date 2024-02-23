package practice2023.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-array-according-to-given-pivot/description/
 */
public class PartitionArrayByPivot {
    public static void main(String[] args) {
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        System.out.println(Arrays.toString(pivotArray(nums, 10)));
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        int[] smaller = new int[len];
        int[] greater = new int[len];

        int i = 0, j = 0, k = 0;
        while (k < len) {
            if (nums[k] < pivot) {
                smaller[i++] = nums[k];
            } else if (nums[k] > pivot) {
                greater[j++] = nums[k];
            }
            k++;
        }
        k = 0;
        while (k < i) {
            nums[k] = smaller[k];
            k++;
        }
        k = len - 1;
        j--;
        while (j >= 0) {
            nums[k] = greater[j];
            j--;
            k--;
        }
        while (i <= k) {
            nums[i] = pivot;
            i++;
        }
        return nums;
    }
}