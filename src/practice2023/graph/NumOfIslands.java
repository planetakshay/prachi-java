package practice2023.graph;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * Implementation is little different from NumberOfIslands.java
 * Avoid use of diagonals.
 */
public class NumOfIslands {
    int[][] directions;
    int rows;
    int columns;

    public int numIslands(char[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        rows = grid.length;
        columns = grid[0].length;
        directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}};

        int islands = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (grid[row][col] == '1') {
                    islands++;
                    connected(grid, row, col);
                }
            }
        }
        System.out.println(Arrays.deepToString(grid));
        return islands;
    }

    private void connected(char[][] grid, int row, int col) {
        grid[row][col] = '0';
        for (int[] dir : directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= columns) {
                continue;
            }
            if (grid[nextRow][nextCol] != '0') {
                connected(grid, nextRow, nextCol);
            }
        }
    }
}