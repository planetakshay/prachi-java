package practice2023.array;

import java.util.Arrays;

public class PointsInsideCircle {

    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] queries = new int[][]{{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};

        System.out.println(Arrays.toString(countPoints(points, queries)));
    }

    public static int[] countPoints(int[][] points, int[][] queries) {
        if (points == null || points.length == 0 || queries == null || queries.length == 0) {
            return null;
        }
        int[] ans = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int count = 0;
            for (int i = 0; i < points.length; i++) {
                double dist = Math.sqrt(Math.pow((queries[j][0] - points[i][0]), 2) + Math.pow((queries[j][1] - points[i][1]), 2));
                if (dist <= queries[j][2]) {
                    count++;
                }
            }
            ans[j] = count;
        }
        return ans;
    }
}
