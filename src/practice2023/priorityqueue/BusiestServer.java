package practice2023.priorityqueue;

import java.util.*;

/**
 * https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/description/
 *
 * This problem is similar to meeting room 3 problem.
 */
public class BusiestServer {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] count = new int[k];
        TreeSet<Integer> free = new TreeSet<>();
        Queue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < k; i++) {
            free.add(i);
        }
        int len = arrival.length;
        for (int i = 0; i < len; i++) {
            int start = arrival[i];
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                int[] curr = busy.poll();
                int serverId = curr[1];
                free.add(serverId);
            }
            if (!free.isEmpty()) {
                Integer busyId = free.ceiling(i % k);
                if (busyId == null) {
                    busyId = free.first();
                }
                free.remove(busyId);
                busy.add(new int[]{start + load[i], busyId});
                count[busyId]++;
            }
        }
        int max = Collections.max(Arrays.stream(count).boxed().toList());
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                answer.add(i);
            }
        }
        return answer;
    }
}