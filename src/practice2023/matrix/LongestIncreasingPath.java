package practice2023.matrix;

/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
 */
public class LongestIncreasingPath {
    private final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int rows;
    private int cols;
    private int longest = Integer.MIN_VALUE;
    private int[][] visited;

    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        cols = matrix[0].length;
        visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                longest = Math.max(longest, helper(matrix, i, j));
            }
        }
        return longest;
    }

    private int helper(int[][] board, int row, int col) {
        if (visited[row][col] != 0) {
            return visited[row][col];
        }
        for (int dir = 0; dir < dirs.length; dir++) {
            int i = row + dirs[dir][0];
            int j = col + dirs[dir][1];
            if (i >= 0 && i < rows && j >= 0 && j < cols && board[row][col] < board[i][j]) {
                visited[row][col] = Math.max(visited[row][col], helper(board, i, j));
            }
        }
        return ++visited[row][col];
    }
}