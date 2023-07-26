package practice2023;

import java.util.Arrays;

/**
 * Solution from Cracking the Coding Interview book
 * https://leetcode.com/problems/maximum-population-year/description/
 */
public class MaximumPeopleAlive {

    public static void main(String[] args) {
        int[][] years = new int[][]{{1950,1961},{1960,1971},{1970,1981}};
        System.out.println("Year with maximum population: " + maximumPopulation(years));

        years = new int[][]{{2008,2026}, {2004,2008}, {2034,2035}, {1999,2050}, {2049,2050}, {2011,2035}, {1966,2033}, {2044,2049}};
        System.out.println("Year with maximum population: " + maximumPopulation(years));
    }

    public static int maximumPopulation(int[][] logs) {
        if(logs == null || logs.length == 0) {
            return 0;
        }
        int min = 1950;
        int max = 2050;
        int[] population = new int[max - min + 2];
        for(int i = 0; i< logs.length; i++) {
            int birth = logs[i][0] - min;
            int death = logs[i][1] - min;
            population[birth] += 1;
            population[death] -= 1;
        }
        System.out.println(Arrays.toString(population));
        int currAlive = 0;
        int maxSoFar = 0;
        int year = 0;
        for(int i = 0; i < population.length ;i++) {
            currAlive += population[i];
            if(currAlive > maxSoFar) {
                maxSoFar = currAlive;
                year = i;
            }
        }
        System.out.println("max alive: " + maxSoFar);
        return year + min;
    }
}
