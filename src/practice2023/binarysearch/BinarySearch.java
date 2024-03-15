package practice2023.binarysearch;

import java.util.Arrays;

/**
 * Example of binary search algorithm.
 *
 * @author Prachi
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {89, 30, 40, 34, 30, 56, 81, 90, 65, 35};
        Arrays.sort(array, 0, array.length - 1);
        int index = binarySearch(array, 0, array.length - 1, 89);
        System.out.println("index = " + index);

        /* array = new int[] {5,7,7,8,8,10};
        Arrays.sort(array, 0, array.length - 1);
        int[] range = binarySearchRange(array, 0, array.length - 1, 8);
        System.out.println("range = " + Arrays.toString(range)); */

        array = new int[]{2, 2};
        Arrays.sort(array, 0, array.length - 1);
        int[] range = searchRange(array, 2);
        System.out.println("range = " + Arrays.toString(range));

        int[] rotatedArray = {3, 4, 5, 6, 7, 8, 9, 10, 11, 1, 2};
        System.out.println("Element in rotated Array found at index: "
                + pivotedBinarySearch(rotatedArray, rotatedArray.length, 5));
        System.out
                .println("Element in rotated Array found at index: "
                        + searchInRotatedArray(rotatedArray, 0,
                        rotatedArray.length, 9));

        range = new int[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        int target = 4;
        System.out.println("First and last occurrence of " + target + " : " + Arrays.toString(searchRangeOneMethod(range, target)));
    }

    public static int binarySearch(int[] array, int start, int end, int item) {
        if (start > end) {
            return -1;
        }
        int pivot = (start + end) / 2;
        if (array[pivot] == item) {
            return pivot;
        } else if (array[pivot] > item) {
            return binarySearch(array, start, pivot - 1, item);
        } else {
            return binarySearch(array, pivot + 1, end, item);
        }
    }

    public static int binarySearchCommon(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static int[] searchRangeOneMethod(int[] nums, int target) {
        int end = nums.length - 1;
        int start = binarySearchCommon(nums, 0, end, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }

        // Now start is at the first occurrence of target.
        // We can begin the search for last occurrence of target
        // from start.
        int first = start; // preserve the first index.
        end = nums.length - 1;
        start = binarySearchCommon(nums, start, end, target);
        return new int[]{first, end};
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] range = new int[2];
        range[0] = findFirstIndex(nums, target);
        range[1] = findLastIndex(nums, target);
        return range;
    }

    public static int findFirstIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }

    public static int findLastIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }

    /*
     * Searches an element no in a pivoted sorted array arrp[] of size arr_size
     */
    public static int pivotedBinarySearch(int[] arr, int arr_size, int no) {
        int pivot = findPivot(arr, 0, arr_size - 1);
        // If we didn't find a pivot, then array is not rotated at all
        if (pivot == -1)
            return binarySearch(arr, 0, arr_size - 1, no);
        // If we found a pivot, then first compare with pivot and then
        // search in two subarrays around pivot
        if (arr[pivot] == no)
            return pivot;
        if (arr[0] <= no)
            return binarySearch(arr, 0, pivot - 1, no);
        else
            return binarySearch(arr, pivot + 1, arr_size - 1, no);
    }

    /*
     * Function to get pivot. For array 3, 4, 5, 6, 1, 2 it will return 3
     */
    public static int findPivot(int[] arr, int low, int high) {
        if (high < low)
            return -1;
        int mid = (low + high) / 2; /* low + (high - low)/2; */
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        else
            return findPivot(arr, mid + 1, high);
    }

    /**
     * @param arr
     * @param low  lower index
     * @param high higher index
     * @param num  target to be searched
     * @return
     */
    // Non- Recursive solution.
    public static int searchInRotatedArray(int[] arr, int low, int high, int num) {
        while (low <= high) {
            int pivot = (low + high) / 2;
            if (num == arr[pivot]) {
                return pivot;
            } else if (arr[low] <= arr[pivot]) {
                if (num > arr[pivot]) {
                    low = pivot + 1;
                } else if (num >= arr[low]) {
                    high = pivot - 1;
                } else {
                    low = pivot + 1;
                }
            } else if (num < arr[pivot]) {
                high = pivot - 1;
            } else if (num <= arr[high]) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return -1;
    }
}