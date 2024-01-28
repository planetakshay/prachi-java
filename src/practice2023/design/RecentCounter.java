package practice2023.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-recent-calls/
 *
 * Leetcode Top 75 interview questions.
 */
public class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while(queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}