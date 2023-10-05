package practice2023.intervals;

import java.util.Arrays;

public class BurstBalloons {

    public static void main(String[] args) {
        int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println("Total no of arrows: " + findMinArrowShots(points));

        points = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println("Total no of arrows: " + findMinArrowShots(points));

        points = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println("Total no of arrows: " + findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        // since points represents xStart and xEnd coordinates for
        // each balloons on the wall. We would need 1 balloon for
        // each non overlapping coordinates.
        // First sort the input by its end coordinate

        // Arrays.sort uses a variation of quick sort which runs
        // with O(NlogN) time complexity and O(LogN) space complexity.

        // Integer.compare takes care of overflow situations.
        // The idea is to sort by end coordinates.

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrows = 1;
        int xStart, xEnd;
        int firstStart = points[0][1];

        for (int[] point : points) {
            xStart = point[0];
            xEnd = point[1];

            if (firstStart < xStart) {
                arrows++;
                firstStart = xEnd;
            }
        }
        return arrows;
    }
}