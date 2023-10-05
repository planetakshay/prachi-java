package practice2023.intervals;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/car-pooling/description/
 */
public class CarPooling {

    public static void main(String[] args) {
        int capacity = 4;
        int[][] trips = new int[][]{{2,1,5},{3,3,7}};
        System.out.println("The car can pick all passengers \nand drop for given trips: " + carPoolingUsingMap(trips, capacity));

        capacity = 5;
        System.out.println("The car can pick all passengers \nand drop for given trips: " + carPoolingUsingMap(trips, capacity));
    }

    public static boolean carPoolingUsingMap(int[][] trips, int capacity) {

        // trips: [[2,1,5],[3,3,7]]
        // trip[0] = {2,1,5}, trip[0][0] = 2 - no of passengers
        // trip[1] = {3,3,7}

        Map<Integer, Integer> timestamp = new TreeMap<>();
        for (int[] trip : trips) {
            // trip[0] = passenger
            // trip[1] = from
            // trip[2] = to
            int startPassenger = timestamp.getOrDefault(trip[1], 0) + trip[0];
            timestamp.put(trip[1], startPassenger);
            int endPassenger = timestamp.getOrDefault(trip[2], 0) - trip[0];
            timestamp.put(trip[2], endPassenger);
        }

        int usedCapacity = 0;
        for (int passsengerChange : timestamp.values()) {
            usedCapacity += passsengerChange;
            if (usedCapacity > capacity) {
                return false;
            }
        }
        return true;
    }

    public static boolean carPoolingBucketSort(int[][] trips, int capacity) {
        int[] timestamp = new int[1001];
        for(int[] trip : trips) {
            timestamp[trip[1]] += trip[0];
            timestamp[trip[2]] -= trip[0];
        }
        int usedCapacity = 0;
        for(int time : timestamp) {
            usedCapacity += time;
            if(usedCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}