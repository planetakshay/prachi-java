package practice2023.intervals;

import java.util.*;

import static practice2023.intervals.IntervalIsCovered.getRange;

/**
 * https://leetcode.com/discuss/interview-question/634115/
 * <p>
 * Merge Intervals with labels.
 */
public class DocComment {

    public static void main(String[] args) {
        List<String> intervals = Arrays.asList("(0, 3): A", "(2, 4): B", "(5, 6): C");
        List<String> output = mergeIntervalsWithLabels(intervals);
        output.stream().forEach(st -> System.out.println(st));

        System.out.println("\n\n\n");
        intervals = Arrays.asList("(0, 3): A", "(0, 3): B", "(2, 4): C", "(5, 6): D");
        output = mergeIntervalsWithLabels(intervals);
        output.stream().forEach(st -> System.out.println(st));
    }

    public static List<String> mergeIntervalsWithLabels(List<String> intervals) {

        if (intervals == null || intervals.isEmpty()) {
            return null;
        }
        List<String> splitIntervals = new LinkedList<>();
        String firstInterval = intervals.get(0);
        String[] first = firstInterval.split(":");
        int[] current = getRange(first[0]);
        String currLabel = getLabel(intervals.get(0));

        int size = intervals.size();
        for (int i = 0; i < size; i++) {
            String interval = intervals.get(i);
            String[] temp = interval.split(":");
            int[] next = getRange(temp[0]);
            String nextLabel = getLabel(interval);

            int currBegin = current[0];
            int currEnd = current[1];
            int nextBegin = next[0];
            int nextEnd = next[1];

            String newInterval = "";

            if ((currBegin == nextBegin && currEnd == nextEnd) && currLabel.equalsIgnoreCase(nextLabel)) {
                continue;
            } else if ((currBegin == nextBegin && currEnd == nextEnd) && !currLabel.equalsIgnoreCase(nextLabel)) {
                splitIntervals.add(buildNewInterval(current, currLabel, nextLabel));
            } else if (currEnd > nextBegin) {
                int[] newInt = new int[2];
                newInt[0] = currBegin;
                newInt[1] = nextBegin;
                splitIntervals.add(buildNewInterval(newInt, currLabel, ""));

                newInt = new int[2];
                newInt[0] = nextBegin;
                newInt[1] = currEnd;
                splitIntervals.add(buildNewInterval(newInt, currLabel, nextLabel));

                newInt = new int[2];
                newInt[0] = currEnd;
                newInt[1] = nextEnd;
                splitIntervals.add(buildNewInterval(newInt, "", nextLabel));

            } else {
                splitIntervals.add(buildNewInterval(next, "", nextLabel));
            }
        }
        return splitIntervals;
    }

    public static String buildNewInterval(int[] curr, String currLabel, String nextLabel) {
        return "(" + curr[0] + "," + curr[1] + "):" + "[" + currLabel + ", " + nextLabel + "]";
    }

    public static String getLabel(String interval) {
        String[] splits = interval.split(":");
        if (splits.length > 1) {
            return splits[1].trim();
        }
        return "";
    }
}
