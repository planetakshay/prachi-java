package practice2023.matrix;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths/editorial/
 */
public class RobotUniquePaths {
    public int uniquePaths(int m, int n) {
        if(m == 1 && n == 1) {
            return 1;
        }
        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }

    public int uniquePathsDp(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] arr : dp) {
            Arrays.fill(arr, 1);
        }
        for(int row=1;row < m; row++) {
            for(int col = 1; col < n; col++) {
                dp[row][col] = dp[row-1][col] + dp[row][col-1];
            }
        }
        return dp[m-1][n-1];
    }
}