package practice2023.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/meeting-rooms-iii/
 */
public class MeetingRoom3 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (m1, m2) -> (m1[0] - m2[0]));
        Queue<Integer> vacant = new PriorityQueue<>();
        Queue<Meeting> occupied = new PriorityQueue<>(
                (m1, m2) -> m1.endTime == m2.endTime ? m1.roomNo - m2.roomNo : m1.endTime - m2.endTime
        );

        int[] usageCount = new int[n];
        int maxUsage = 0;
        // initially all rooms are available.
        for (int i = 0; i < n; i++) {
            vacant.add(i);
        }

        for (int[] meet : meetings) {
            // Keep marking room as vacant when earlier meeting has ended before next begins.
            while (!occupied.isEmpty() && occupied.peek().endTime <= meet[0]) {
                vacant.add(occupied.remove().roomNo);
            }

            int startTime = meet[0];
            if (vacant.isEmpty()) {
                Meeting endMeet = occupied.remove();
                startTime = endMeet.endTime;
                vacant.add(endMeet.roomNo);
            }
            int room = vacant.remove();
            usageCount[room]++;
            int interval = meet[1] - meet[0];
            occupied.add(new Meeting(interval + startTime, room));
            maxUsage = Math.max(maxUsage, usageCount[room]);
        }
        for (int i = 0; i < n; i++) {
            if (usageCount[i] == maxUsage) {
                return i;
            }
        }
        return maxUsage;
    }
}

class Meeting {
    int endTime;
    int roomNo;

    public Meeting(int endTime, int roomNo) {
        this.endTime = endTime;
        this.roomNo = roomNo;
    }
}