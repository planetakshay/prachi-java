package practice2023.matrix;

/**
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 */
public class MinimumPathSum {
    public int minPathSumInPlace(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols; j >= 0; j--) {
                if (i == rows - 1 && j < cols - 1) {
                    grid[i][j] += grid[i][j + 1];
                } else if (i < rows - 1 && j == cols - 1) {
                    grid[i][j] += grid[i + 1][j];
                } else if (i < rows - 1 && j < cols - 1) {
                    grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
                }
            }
        }
        return grid[0][0];
    }
    public int minPathSumRecursive(int[][] grid) {
        return helper(grid, 0, 0);
    }
    public int helper(int[][] grid, int row, int col) {
        if (row >= grid.length || col >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }
        return grid[row][col] + Math.min(helper(grid, row + 1, col), helper(grid, row, col + 1));
    }
}