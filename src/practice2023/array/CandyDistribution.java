package practice2023.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/candy/description/
 */
public class CandyDistribution {

    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }
        int len = ratings.length;
        int[] candies = new int[len];
        Arrays.fill(candies, 1);
        for(int i = 1; i < len; i++) {
            if(ratings[i-1] < ratings[i]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        int totalCandies = 0;
        for(int i = len - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            totalCandies += candies[i];
        }
        return totalCandies;
    }
}
