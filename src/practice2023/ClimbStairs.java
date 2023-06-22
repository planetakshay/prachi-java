package practice2023;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println("No of ways the steps can be climbed: " + waysToClimbStairs(6));
    }
    public static int waysToClimbStairs(int n) {

        if(n <= 0) {
            return 0;
        }
        if(n > 0 && n < 3) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
