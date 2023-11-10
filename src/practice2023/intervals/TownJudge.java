package practice2023.intervals;

import java.util.List;

/**
 * https://leetcode.com/problems/find-the-celebrity/
 *
 * IK problem set Graphs
 * Interview Kickstart
 *
 *
 */
public class TownJudge {

    public static void main(String[] args) {
        int[][] trust = new int[][]{{1,2}};
        System.out.println("Judge: " + findJudge(2,trust));
    }
    public static int findJudge(int n, int[][] trust) {
        if(trust == null) {
            return n;
        }
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        int judge = -1;
        for(int i = 0; i < trust.length; i++) {
            int[] temp = trust[i];
            outdegree[temp[0] - 1]++;
            indegree[temp[1] - 1]++;
        }
        for(int i = 0; i < n; i++) {
            if(indegree[i] == n - 1 && outdegree[i] == 0) {
                judge = i;
                break;
            }
        }
        if(judge > -1) {
            judge++;
        }
        return judge;
    }
}