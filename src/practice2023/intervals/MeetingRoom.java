package practice2023.intervals;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/meeting-rooms/
 *
 *
 */
public class MeetingRoom {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0,30},{5,10},{15,20}};
        System.out.println("Can attend all the meetings: " + bruteForce(intervals));

        intervals = new int[][]{{7,10},{2,4}};
        System.out.println("Can attend all the meetings: " + bruteForce(intervals));
    }
    public static boolean bruteForce(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i=0;i<intervals.length - 1; i++) {
            if(intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }
        return true;
    }
}