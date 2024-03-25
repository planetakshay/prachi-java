package practice2023.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
 */
public class ShortestPathInBinaryMatrix {
    private static final int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[0][0] != 0 || grid[rows - 1][cols - 1] != 0) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        grid[0][0] = 1;
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];
            if (row == rows - 1 && col == cols - 1) {
                return distance;
            }
            for (int[] dir : dirs) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                if (nRow < 0 || nRow >= rows || nCol < 0 || nCol >= cols || grid[nRow][nCol] != 0) {
                    continue;
                }
                queue.offer(new int[]{nRow, nCol});
                grid[nRow][nCol] = distance + 1;
            }
        }
        return -1;
    }
}