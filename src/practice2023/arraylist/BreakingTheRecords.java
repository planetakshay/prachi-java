package practice2023.arraylist;

import java.util.Arrays;
import java.util.List;

/**
 * HackerRank challenge.
 * <p>
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 */
public class BreakingTheRecords {
    public static void main(String[] args) {
        List<Integer> scores = Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1);
        System.out.println(breakingRecords(scores));
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int minCount = -1, maxCount = -1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int score : scores) {
            if (score > max) {
                maxCount++;
                max = score;
            }
            if (score < min) {
                minCount++;
                min = score;
            }
        }
        return Arrays.asList(maxCount, minCount);
    }
}
