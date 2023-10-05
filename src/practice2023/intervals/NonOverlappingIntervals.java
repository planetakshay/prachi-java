package practice2023.intervals;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 *
 */
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        if (intervals == null || intervals.length == 0) {
            return ans;
        }
        int k = Integer.MIN_VALUE;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (start >= k) {
                k = end;
            } else {
                ans++;
            }
        }
        return ans;
    }
}