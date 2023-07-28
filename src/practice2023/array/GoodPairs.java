package practice2023.array;

import java.util.*;

public class GoodPairs {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1, 1, 3};
        System.out.println("Good pairs: " + numIdenticalPairsBF(nums));
    }

    public static int numIdenticalPairsBF(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
