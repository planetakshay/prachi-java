package practice2023.intervals;

import java.util.*;

/**
 * https://www.careercup.com/question?id=5687334637404160
 */
public class IntervalIsCovered {

    public static void main(String[] args) {
        List<String> intervals = new LinkedList<>(Arrays.asList("(2,5)", "(5,7)", "(1,4)"));
        System.out.println("Is covered for range 1: " + isCovered(intervals, "(1,6)"));

        intervals = new LinkedList<>(Arrays.asList("(1,4)", "(6,7)", "(2,5)"));
        System.out.println("Is covered for range 2: " + isCovered(intervals, "(5,6)"));

        intervals = new LinkedList<>(List.of("(1,4)"));
        System.out.println("Is covered for range 3: " + isCovered(intervals, "(1,4)"));
    }

    public static boolean isCovered(List<String> intervals, String targetInterval) {
        if (intervals == null || intervals.isEmpty()) {
            return false;
        }
        Collections.sort(intervals);
        int[] target = getRange(targetInterval);
        int[] current = getRange(intervals.get(0));

        if (withinRange(current, target)) {
            return true;
        }
        boolean isCovered = false;
        for (int i = 1; i < intervals.size(); i++) {
            int[] next = getRange(intervals.get(i));
            int currBegin = current[0];
            int currEnd = current[1];
            int nextBegin = next[0];
            int nextEnd = next[1];

            if (currBegin == nextBegin && currEnd == nextEnd) { // repeating intervals.
                continue;
            } else if (currEnd >= nextBegin) { // overlapping intervals. Merge them
                current[1] = Math.max(currEnd, nextEnd);
            } else { // scattered intervals.
                current = next;
            }
            isCovered = current[0] <= target[0] && target[1] <= current[1];
        }
        return isCovered;
    }

    public static boolean withinRange(int[] current, int[] target) {
        return current[0] <= target[0] && target[1] <= current[1];
    }

    /*

    /**
     * Not solving the actual problem.
     *
     * @param intervals
     * @param targetInterval
     * @return
    public static boolean isCovered(List<String> intervals, String targetInterval) {
        if (intervals == null || intervals.isEmpty()) {
            return false;
        }
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(1);
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(1, Collections.reverseOrder());

        for (String interval : intervals) {
            int[] range = getRange(interval);
            minQueue.add(range[0]);
            if (minQueue.size() > 1) {
                minQueue.poll();
            }
            maxQueue.add(range[1]);
            if (maxQueue.size() > 1) {
                maxQueue.poll();
            }
            int[] targetRange = getRange(targetInterval);
            if (minQueue.peek() >= targetRange[0] && maxQueue.peek() <= targetRange[1]) {
                return true;
            }
        }
        return false;
    }*/

    public static int[] getRange(String interval) {
        if (interval == null || interval.isEmpty()) {
            return null;
        }

        String withoutParen = interval.substring(1, interval.length() - 1);
        String[] lowHigh = withoutParen.split(",");
        int[] range = new int[2];

        try {
            range[0] = Integer.parseInt(lowHigh[0].trim());
            range[1] = Integer.parseInt(lowHigh[1].trim());
        } catch (NumberFormatException e) {
            System.out.println("Exception during parsing range. " + e.getMessage());
        }
        return range;
    }
}