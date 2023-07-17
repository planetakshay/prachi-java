package practice2023;

import java.util.HashMap;
import java.util.Map;

public class WellPerformingInterval {
    public static void main(String[] args) {
        int[] hours = new int[] {9,9,6,0,6,6,9};
        System.out.println("The well-performing interval length: " + findWellPerformingInterval(hours));
        // System.out.println("The well-performing interval length: " + longestWPI(hours));


        hours = new int[] {6,6,9};
        System.out.println("The well-performing interval length: " + findWellPerformingInterval(hours));
        // System.out.println("The well-performing interval length: " + longestWPI(hours));

        hours = new int[] {6,6,6};
        System.out.println("The well-performing interval length: " + findWellPerformingInterval(hours));
    }

    public static int findWellPerformingInterval(int[] hours) {
        if(hours == null || hours.length == 0) {
            return -1;
        }

        Map<Integer, Integer> sumToIndex = new HashMap();
        int size = hours.length;
        int maxInterval = 0;
        int sum = 0;

        for(int i = 0;i < size;i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if(!sumToIndex.containsKey(sum)) {
                sumToIndex.put(sum, i);
            }
            if(sum > 0) {
                maxInterval = i + 1;
            } else if(sumToIndex.containsKey(sum-1)) {
                maxInterval = Math.max(maxInterval, i - sumToIndex.get(sum-1));
            }
        }
        return maxInterval;
    }
}