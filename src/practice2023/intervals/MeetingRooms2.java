package practice2023.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        int len = intervals.length;
        /* PriorityQueue<Integer> allocator = new PriorityQueue<>(len, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }); */

        PriorityQueue<Integer> allocator = new PriorityQueue<>();
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        allocator.add(intervals[0][1]);

        for(int i = 1; i < len; i++) {
            if(intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }
}