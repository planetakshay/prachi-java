package practice2023;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array arr[], find the maximum j – i such that arr[i] <= arr[j]
 * <p>
 * https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 */
public class StockPriceInterval {
    public static void main(String[] args) {
        int[] prices = new int[]{50, 52, 58, 54, 57, 51, 55, 60, 62, 65, 68, 72, 62, 61, 59, 63, 72};
        System.out.println("Max Interval: " + (inefficient(prices)));
        /* System.out.println("Max Interval using while: " + (inefficientWhile(prices))); */
        System.out.println("O(N) time complexity: " + findLongest(prices));
        prices = new int[]{10, 1, 5};
        System.out.println("Max Interval: " + (inefficient(prices)));
        /*System.out.println("Max Interval using while: " + (inefficientWhile(prices)));*/
        System.out.println("O(N) time complexity: " + findLongest(prices));
    }
    // O(n2) complexity.
    public static int inefficient(int[] array) {
        int distance = 0;
        int maxDistance = Integer.MIN_VALUE;
        int low = 0;
        int high = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] >= array[j]) {
                    distance = j - i;
                    low = i;
                    high = j;
                }
            }
            if (maxDistance < distance) {
                maxDistance = distance;
            }
        }
        System.out.println("\nDistance = " + distance + "\nmaxDistance = " + maxDistance + "\nLow = " + low + ", High = " + high);
        System.out.println("-------------------------------------------------");
        return maxDistance;
    }
    public static int inefficientWhile(int[] array) {
        int distance = 0;
        int maxDistance = Integer.MIN_VALUE;
        int i = 0, j = i + 1;
        int low = 0, high = 0;
        while (i < array.length - 1) {
            while (j < array.length) {
                if (array[i] >= array[j]) {
                    distance = j - i;
                    low = i;
                    high = j;
                }
                j++;
            }
            j = i + 1;
            i++;
            if (maxDistance < distance) {
                maxDistance = distance;
                System.out.println("\nDistance = " + distance + "\nmaxDistance = " + maxDistance + "\nLow = " + low + " High = " + high);
            }
        }
        System.out.println("-------------------------------------------------");
        return maxDistance;
    }

    /**
     * WIP: Not returning expected results.
     * @param prices
     * @return
     */
    public static int findLongest(int[] prices) {
        int start = 0, end = start + 1;
        int currInterval = 0, maxInterval = 0;

        for(int i = 1; i < prices.length;i++) {
            if(prices[start] > prices[end]) {
                currInterval = end - start;
            } else {
                start = end;
            }
            end++;
        }
        maxInterval = Math.max(maxInterval, currInterval);
        System.out.println("-------------------------------------------------");
        return maxInterval;
    }
}