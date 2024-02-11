package practice2023.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/interval-list-intersections/description/
 */
public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersection = new ArrayList<>();
        int i = 0, j = 0;

        int fLen = firstList.length;
        int sLen = secondList.length;

        while (i < fLen && j < sLen) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if (start <= end) {
                intersection.add(new int[]{start, end});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return intersection.toArray(new int[intersection.size()][]);
    }
}