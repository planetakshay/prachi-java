package practice2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * https://www.educative.io/blog/google-coding-interview-questions
 * https://leetcode.com/problems/merge-intervals/description/
 */
public class MergeOverlappingInterval {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}, {17, 19}};
        int[][] output = merge(intervals);
        System.out.print(Arrays.deepToString(output));

        intervals = new int[][]{{6,20}};
        System.out.println("\n\nTotal content watched for = " + computeWatchTime(intervals) + " hours");

        intervals = new int[][]{{1, 3}, {4, 5}, {6, 7}};
        System.out.println("\n\nTotal content watched for = " + computeWatchTime(intervals) + " hours");

        intervals = new int[][]{{1, 5}, {2, 3}};
        System.out.println("\n\nTotal content watched for = " + computeWatchTime(intervals) + " hours");

        intervals = new int[][]{{1, 3}, {4, 5}, {4, 5}, {1, 3}, {5, 9}};
        System.out.println("\n\nTotal content watched for = " + computeWatchTime(intervals) + " hours");
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        // Sorting below is optional.
        // Check with interviewer if input is sorted before writing.
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        List<int[]> mergedList = new LinkedList();
        int[] current = intervals[0];
        mergedList.add(current);

        for (int[] interval : intervals) {
            int curEnd = current[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            if (curEnd >= nextBegin) {
                current[1] = Math.max(curEnd, nextEnd);
            } else {
                current = interval;
                mergedList.add(current);
            }
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }

    /**
     * Roblox phone screen
     * Interviewer: Devakinandan Panda
     * @param intervals
     * @return
     */
    public static int computeWatchTime(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        if(intervals.length == 1) {
            int[] interval = intervals[0];
            return (interval[1] - interval[0]);
        }
        // Sorting below is optional.
        // Check with interviewer if input is sorted before writing.
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        int[] current = intervals[0];
        int count = (current[1] - current[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int curEnd = current[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            // repeating intervals. Since the data is sorted at this
            // point we will ignore repeating intervals.

            if ((current[0] == nextBegin) && (current[1] == nextEnd)) {
                continue;
            }
            if (curEnd >= nextBegin) {
                // Overlap found so need to deduct previously calculated
                // period.
                count -= (current[1] - current[0]);
                current[1] = Math.max(curEnd, nextEnd);
            } else {
                current = interval;
            }
            count += (current[1] - current[0]);
        }
        return count;
    }
}
