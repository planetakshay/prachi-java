package practice2023.graph;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/number-of-islands/description/
 */
public class NumberOfIslands {
    static int[] rowOffset = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] colOffset = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int allDirections = 8;
    // Below two methods are from IK graph class.
    static Integer count_islands(ArrayList<ArrayList<Integer>> matrix) {
        if (matrix == null || matrix.get(0).size() == 0) {
            return 0;
        }
        int rows = matrix.size();
        int cols = matrix.get(0).size();

        int countIslands = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!matrix.get(row).get(col).equals(0)) {
                    countIslands++;
                    dfs(matrix, row, col);
                }
            }
        }
        return countIslands;
    }

    static void dfs(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        matrix.get(row).set(col, 0);
        for (int i = 0; i < allDirections; i++) {
            int nextRow = row + rowOffset[i];
            int nextCol = col + colOffset[i];
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                continue;
            }
            if (!matrix.get(nextRow).get(nextCol).equals(0)) {
                dfs(matrix, nextRow, nextCol);
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }
        return num_islands;
    }

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        // Mark the cell currently being visited by setting it to 0.
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
