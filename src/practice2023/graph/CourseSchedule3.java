package practice2023.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/course-schedule-iii/description/
 */
public class CourseSchedule3 {
    public static void main(String[] args) {
        int[][] courses = new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println("Maximum courses that can be taken: " + scheduleCourse(courses));
    }

    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> (b - a));

        int time = 0;
        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];
            if (time + duration <= lastDay) {
                queue.offer(duration);
                time += duration;
            } else if (!queue.isEmpty() && queue.peek() > duration) {
                time += duration - queue.poll();
                queue.offer(duration);
            }
        }
        return queue.size();
    }
}
