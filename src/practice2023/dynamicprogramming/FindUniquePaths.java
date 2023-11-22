package practice2023.dynamicprogramming;

/**
 * Find all possible unique paths from (0,0) to (m-1, n-1)
 * in a m x n matrix with obstacles.
 *
 * https://leetcode.com/problems/unique-paths-ii/
 *
 * covered in IK timed test.
 *
 * Inteview Kickstart
 */
public class FindUniquePaths {
    public static void main(String args) {

    }

    public int findUniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        // 0 should be treated as an obstacle.
        // We either cannot start the traversal or destination is the
        // obstacle making it impossible to reach the last cell in the grid
        if(grid[0][0] == 0 || grid[m-1][n-1] == 0) {
            return 0;
        }
        memo[0][0] = 1;
        for(int i=1;i<n;i++) {
            if(grid[0][i] != 0) {
                memo[0][i] = memo[0][i-1];
            }
        }
        for(int i=1;i<m;i++) {
            if(grid[i][0] != 0) {
                memo[i][0] = memo[i-1][0];
            }
        }

        for(int i=1;i < m;i++) {
            for(int j = 1; j < n; j++) {
                memo[i][j] = memo[i-1][j] + memo[i][j-1];
            }
        }
        return memo[m-1][n-1];
    }
}