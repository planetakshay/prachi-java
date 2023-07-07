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
        System.out.println("\nInput: \n" + "(0, 3): A\n" + "(2, 4): B\n" + "(5, 6): C");
        List<Interval> intervals = Arrays.asList(new Interval("(0, 3): A"), new Interval("(2, 4): B"), new Interval("(5, 6): C"));
        List<Interval> output = mergeIntervalsWithLabels(intervals);
        System.out.println("\nOutput: ");
        output.stream().forEach(interval -> System.out.println(interval));

        System.out.println("\n\nInput: \n(0, 3): A\n" + "(0, 3): B\n" + "(2, 4): C\n" + "(5, 6): D");
        intervals = Arrays.asList(new Interval("(0, 3): A"), new Interval("(0, 3): B"), new Interval("(2, 4): C"), new Interval("(5, 6): D"));
        output = mergeIntervalsWithLabels(intervals);
        System.out.println("\nOutput: ");
        output.stream().forEach(interval -> System.out.println(interval));
    }

    public static List<Interval> mergeIntervalsWithLabels(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return null;
        }
        int size = intervals.size();
        Interval curr = intervals.get(0);
        List<Interval> splitIntervals = new LinkedList<>();
        for (int i = 1; i < size; i++) {

            Interval next = intervals.get(i);

            if (curr.equals(next)) {
                continue;
            } else if (curr.getStart() == next.getStart() && curr.getEnd() == next.getEnd() && !curr.getLabel().equals(next.getLabel())) {
                // merge only label.
                List<String> labelsSoFar = new LinkedList<>(curr.getLabel());
                labelsSoFar.addAll(next.getLabel());
                curr.setLabel(labelsSoFar);

            } else if (curr.getEnd() > next.getStart()) {
                //merge intervals and labels.
                List<String> mergedLabels = new LinkedList<>();
                mergedLabels.addAll(curr.getLabel());
                mergedLabels.addAll(next.getLabel());

                Interval split = new Interval(curr.getStart(), next.getStart(), curr.getLabel());
                splitIntervals.add(split);

                split = new Interval(next.getStart(), curr.getEnd(), mergedLabels);
                splitIntervals.add(split);

                split = new Interval(curr.getEnd(), next.getEnd(), next.getLabel());
                splitIntervals.add(split);
            } else {
                splitIntervals.add(next);
            }
        }
        return splitIntervals;
    }
}

class Interval {
    int start;
    int end;
    List<String> label;
    public Interval(int start, int end, List<String> labels) {
        this.start = start;
        this.end = end;
        this.label = labels;
    }
    public Interval(String interval) {
        String[] splits = interval.split(":");
        int[] range = getRange(splits[0]);

        this.start = range[0];
        this.end = range[1];

        this.label = List.of(splits[1].trim());
    }
    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public int getEnd() {
        return end;
    }
    public void setEnd(int end) {
        this.end = end;
    }
    public List<String> getLabel() {
        return label;
    }
    public void setLabel(List<String> label) {
        this.label = label;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interval interval)) return false;
        return start == interval.start && end == interval.end && Objects.equals(label, interval.label);
    }
    @Override
    public int hashCode() {
        return Objects.hash(start, end, label);
    }
    @Override
    public String toString() {
        return "(" + start + ", " + end + ") : " + Arrays.toString(label.toArray());
    }
}
