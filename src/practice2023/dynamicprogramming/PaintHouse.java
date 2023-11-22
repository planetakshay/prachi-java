package practice2023.dynamicprogramming;

/**
 * https://leetcode.com/problems/paint-house/description/
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }
        int len = costs.length;
        int[] prev = costs[len - 1];
        for(int i=len - 2; i >= 0; i--) {
            int[] curr = costs[i];
            curr[0] += Math.min(prev[1], prev[2]);
            curr[1] += Math.min(prev[0], prev[2]);
            curr[2] += Math.min(prev[0], prev[1]);
            prev = curr;
        }
        return Math.min(Math.min(prev[0], prev[1]), prev[2]);
    }
}