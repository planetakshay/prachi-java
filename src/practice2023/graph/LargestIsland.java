package practice2023.graph;

/**
 * Interview Kickstart
 *
 * Covered in IK graph problem set.
 *
 * https://leetcode.com/problems/max-area-of-island/description/
 */
public class LargestIsland {
    int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }
        return maxArea;
    }

    int dfs(int[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        return (1 + dfs(grid, r - 1, c) +
                dfs(grid, r + 1, c) +
                dfs(grid, r, c - 1) +
                dfs(grid, r, c + 1));
    }
}
