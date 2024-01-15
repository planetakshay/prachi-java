package practice2023.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Counting sort has a time complexity of O(N).
 * When elements in the array have a fixed range
 * for e.g. between 1...N, counting sort algorithm
 * should be used for sorting.
 * <p>
 * covered in IK sorting foundation material.
 *
 * First find the range of the integers and compute
 * frequencies for each element.
 *
 * As per frequencies of each element populate the
 * original array starting at index 0.
 */
public class CountingSort {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 1, 5, 8, 3, 9, 4, 1, 7, 5, 5, 5, 8, 7, 7, 7, 7);
        countingSort(arr);
    }

    public static void countingSort(List<Integer> arr) {
        System.out.println("Unsorted: " + arr);
        if (arr == null || arr.size() == 0) {
            return;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> frequency = new HashMap<>();
        for (Integer num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int index = 0;
        for (int i = min; i <= max; i++) {
            int count = frequency.getOrDefault(i, 0);
            while (count > 0) {
                arr.set(index++, i);
                count--;
            }
        }
        System.out.println("Sorted: " + arr);
    }
}