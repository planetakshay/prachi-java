package practice2023.sorting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/description/
 */
public class SortColor {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println("Arrange in Dutch Flag colors: " + Arrays.toString(nums));

        nums = new int[]{2, 0, 1};
        sortColors(nums);
        System.out.println("Arrange in Dutch Flag colors: " + Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // The idea of solution is to move curr pointer along the
        // array, if nums[curr] = 0 - swap it with nums[p0],
        // if nums[curr] = 2 - swap it with nums[p2].
        int c0 = 0, c2 = nums.length - 1, curr = 0;
        while (curr <= c2) {
            int temp = -1;
            if (nums[curr] == 0) {
                temp = nums[c0];
                nums[c0++] = nums[curr];
                nums[curr++] = temp;
                // c0++;
                // curr++;
            } else if (nums[curr] == 2) {
                temp = nums[curr];
                nums[curr] = nums[c2];
                nums[c2--] = temp;
            } else {
                curr++;
            }
        }
    }

    static ArrayList<Character> dutchFlagSort(ArrayList<Character> balls) {
        // Write your code here.
        int r = 0, b = balls.size() - 1;
        int g = 0;
        while (g <= b) {
            char temp = '\u0000';
            if (balls.get(g) == 'R') {
                temp = balls.get(r);
                balls.set(r++, balls.get(g));
                balls.set(g++, temp);
            } else if (balls.get(g) == 'B') {
                temp = balls.get(g);
                balls.set(g, balls.get(b));
                balls.set(b--, temp);
            } else {
                g++;
            }
        }
        return balls;
    }
}