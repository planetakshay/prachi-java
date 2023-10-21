package practice2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * Start with the last index of first array.
 * Compare the last element of second array with last populated
 * element of first array. If greater than put it at the last
 * index of the first array.
 * <p>
 * handle negative values of first and last array indices.
 */
public class MergeSortedArrays {

    public static void main(String[] args) {
        System.out.println("First Test case: ");
        int[] nums1 = new int[]{2, 4, 6, 0, 0, 0};
        int[] nums2 = new int[]{1, 3, 5};
        merge(nums1, 3, nums2, nums2.length);
        Arrays.stream(nums1).forEach(ele -> System.out.print("\t" + ele));

        System.out.println("\nSecond Test case: ");
        nums1 = new int[]{1};
        nums2 = new int[]{};
        merge(nums1, 1, nums2, nums2.length);
        Arrays.stream(nums1).forEach(ele -> System.out.print("\t" + ele));

        System.out.println("\nThird Test case: ");
        nums1 = new int[]{0};
        nums2 = new int[]{1};
        merge(nums1, 1, nums2, nums2.length);
        Arrays.stream(nums1).forEach(ele -> System.out.print("\t" + ele));

        System.out.println("\nCracking Coding Interview Test case: ");
        nums1 = new int[]{1, 2, 4, 9, 10, 0, 0, 0, 0};
        nums2 = new int[]{2, 5, 6, 8};
        mergeCrackingCodingInterview(nums1, nums2, 5, nums2.length);
        Arrays.stream(nums1).forEach(ele -> System.out.print("\t" + ele));

        List<Integer> first = Arrays.asList(1, 3, 5);
        List<Integer> second = Arrays.asList(2, 4, 6, 0, 0, 0);

        mergeOneIntoAnother(first, second);
        System.out.println("\nSECOND ARRAY AFTER MERGE: " + second);
    }

    // Simple merge sort.
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return null;
        }
        if (arr1 == null || arr1.length == 0) {
            return arr2;
        } else if (arr2 == null || arr2.length == 0) {
            return arr1;
        }
        int[] mergedArray = new int[arr1.length + arr2.length];
        // indices for arr1, arr2 and arr3 respectively.
        int i = 0, j = 0, k = 0;
        // compare elements of arr1 and arr2 and set the values in
        // arr3 in ascending order.
        while (i < arr1.length && j < arr2.length) {

            // Less than or equal is important to ensure the stability
            // of the algorithm. i.e. when there are multiple elements
            // with same value in the array the sorting algorithm should
            // avoid unnecessary swaps and preserve the original order
            // of the duplicate elements.

            if (arr1[i] <= arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            mergedArray[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            mergedArray[k++] = arr2[j++];
        }
        return mergedArray;
    }

    /**
     * @param nums1 First sorted array with enough empty cells to put
     *              elements of second array while maintaining
     *              the sort order of the fist array
     * @param m     last populated index of first array.
     * @param nums2 second sorted array.
     * @param n     last index of the second array.
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, index = nums1.length - 1;
        while (index >= 0) {
            if (i < 0) {
                nums1[index] = nums2[j--];
            } else if (j < 0) {
                nums1[index] = nums1[i--];
            } else {
                if (nums2[j] >= nums1[i]) {
                    nums1[index] = nums2[j--];
                } else {
                    nums1[index] = nums1[i--];
                }
            }
            index--;
        }
        System.out.println("MERGED ARRAY: " + Arrays.toString(nums1));
        // Compute median.
        int len = nums1.length;
        int half = len / 2;
        if (len % 2 == 0) {
            System.out.println("Median of merged arrays: " + ((float) (nums1[half - 1] + nums1[half])) / 2);
        } else {
            System.out.println("Median of merged arrays: " + nums1[half]);
        }
    }

    public static void mergeCrackingCodingInterview(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;

        int mergedIndex = lastB + lastA - 1;

        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[mergedIndex] = a[indexA];
                indexA--;
            } else {
                a[mergedIndex] = b[indexB];
                indexB--;
            }
            mergedIndex--;
        }
    }

    static List<Integer> mergeOneIntoAnother(List<Integer> first, List<Integer> second) {

        // Write your code here.
        int j = first.size() - 1;
        int i = j, index = second.size() - 1;

        while (index >= 0) {
            if (i < 0) {
                second.set(index, first.get(j--));
            } else if (j < 0) {
                second.set(index, second.get(i--));
            } else {
                if (first.get(j) >= second.get(i)) {
                    second.set(index, first.get(j--));
                } else {
                    second.set(index, second.get(i--));
                }
            }
            index--;
        }
        return second;
    }
}