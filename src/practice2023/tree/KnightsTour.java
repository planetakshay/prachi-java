package practice2023.tree;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/the-knights-tour/submissions/
 *
 * IK problem sets Graphs.
 *
 * Interview Kickstart
 */
public class KnightsTour {
    private static final int[][] dirs = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    int[][] board;
    public int[][] tourOfKnight(int m, int n, int r, int c) {
        board = new int[m][n];
        Arrays.stream(board).forEach(A -> Arrays.fill(A, -1));
        dfs(m, n, r, c, 0);
        return board;
    }
    private boolean dfs(int m, int n, int i, int j, int step) {
        // all cells are visited.
        if (step == m * n) {
            return true;
        }
        // out of bounds.
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        // encountered already visited.
        if (board[i][j] != -1) {
            return false;
        }
        board[i][j] = step;
        for (int[] dir : dirs) {
            if (dfs(m, n, i + dir[0], j + dir[1], step + 1)) {
                return true;
            }
        }
        board[i][j] = -1;
        return false;
    }
}