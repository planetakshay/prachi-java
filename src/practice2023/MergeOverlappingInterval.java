package practice2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * https://www.educative.io/blog/google-coding-interview-questions
 * https://leetcode.com/problems/merge-intervals/description/
 *
 */
public class MergeOverlappingInterval {

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1,3},{2,6},{8,10},{15,18}, {17,19}};
        int[][] output = merge(intervals);
        System.out.print(Arrays.deepToString(output));
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) {
            return intervals;
        }
        // Sorting below is optional.
        // Check with interviewer if input is sorted before writing.
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        List<int[]> mergedList = new LinkedList();
        int[] current = intervals[0];
        mergedList.add(current);

        for(int[] interval : intervals) {
            int curEnd = current[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            if(curEnd >= nextBegin) {
                current[1] = Math.max(curEnd, nextEnd);
            } else {
                current = interval;
                mergedList.add(current);
            }
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}
