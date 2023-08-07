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
     *
     * 50, 52, 58, 54, 57, 51, 55, 60, 62, 65, 68, 72, 62, 61, 59, 63, 72
     *
     */
    public static int findLongest(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int interval = 0;
        int maxInterval = 0;
        int curMax = prices[0];
        for(int i = 0; i < prices.length;i++) {
            while (!stack.empty() && prices[stack.peek()] > prices[i]) {
                interval = i - stack.peek();
                maxInterval = Math.max(interval, maxInterval);
                stack.pop();
            }
            if(curMax <= prices[i]) {
                stack.push(i);
                curMax = prices[i];
            }
        }

        return maxInterval;
    }
}