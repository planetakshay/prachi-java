package practice2023.intervals;

import java.util.*;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1,3}, {6,9}};
        int[][] merged = insert(intervals, new int[]{2,5});
        System.out.println("Merged Intervals " + Arrays.deepToString(merged));

        intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        merged = insert(intervals, new int[]{4,8});
        System.out.println("Merged Intervals " + Arrays.deepToString(merged));
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        Set<int[]> mergedList = new LinkedHashSet<>();
        if(intervals == null || intervals.length == 0) {
            mergedList.add(newInterval);
            return mergedList.stream().toArray(int[][] :: new);
        }
        int len = intervals.length;
        int i = 0;
        while(i < len && intervals[i][1] < newInterval[0]) {
            mergedList.add(intervals[i++]);
        }
        while(i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        mergedList.add(newInterval);
        while(i < len ) {
            mergedList.add(intervals[i++]);
        }
        return mergedList.stream().toArray(int[][] :: new);
    }
}