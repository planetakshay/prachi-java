package practice2023.array;

import java.util.Arrays;

/**
 * CodeSignal problem.
 *
 * Count missing consecutive numbers.
 */
public class MissingConsecutiveNumbers {

    public static void main(String[] args) {
        int[] nums = {6, 2, 3, 8};
        System.out.println(findMissing(nums));
    }
    public static int findMissing(int[] statues) {
        int count = 0;
        if(statues == null || statues.length == 0) {
            return count;
        }
        Arrays.sort(statues);
        int i = 0;
        int len = statues.length;
        while(i < statues.length - 1) {
            int diff = statues[i+1] - statues[i];
            count += diff == 1 ? 0 : diff - 1;
            i++;
        }
        return count;
    }
}
