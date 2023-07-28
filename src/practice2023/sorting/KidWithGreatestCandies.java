package practice2023.sorting;

import com.sun.jdi.BooleanValue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KidWithGreatestCandies {

    public static void main(String[] args) {
        int[] candies = new int[]{2,3,5,1,3};
        List<Boolean> greatest = kidsWithCandies(candies, 3);
        System.out.println(Arrays.toString(greatest.toArray()));

        candies = new int[]{4,2,1,1,2};
        greatest = kidsWithCandies(candies, 1);
        System.out.println(Arrays.toString(greatest.toArray()));

        candies = new int[]{12, 1, 12};
        greatest = kidsWithCandies(candies, 10);
        System.out.println(Arrays.toString(greatest.toArray()));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < candies.length; i++) {
            max = Math.max(candies[i], max);
        }
        List<Boolean> greatestCandies = new LinkedList<>();
        for(int i=0; i<candies.length;i++) {
            if(candies[i] + extraCandies >= max) {
                greatestCandies.add(true);
            } else {
                greatestCandies.add(false);
            }
        }
        return greatestCandies;
    }
}
