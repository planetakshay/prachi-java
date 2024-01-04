package practice2023.hackerrank;

import java.util.Arrays;
import java.util.List;

/**
 * Salesforce phone screen.
 */

public class NumbersWithUniqueDigits {

    public static void main(String[] args) {
        List<List<Integer>> arr = Arrays.asList(Arrays.asList(80, 120), Arrays.asList(1,10));
        numbersWithUniqueDigits(arr);
    }

    public static void numbersWithUniqueDigits(List<List<Integer>> arr) {
        if (arr == null || arr.size() == 0) {
            return;
        }
        for (List<Integer> range : arr) {
            int start = range.get(0);
            int end = range.get(1);
            int total = 0;
            for (int num = start; num <= end; num++) {
                boolean[] seen = new boolean[10];
                int curr = num;
                boolean duplicate = false;
                while (curr != 0) {
                    int digit = curr % 10;
                    if (seen[digit]) {
                        duplicate = true;
                        break;
                    }
                    seen[digit] = true;
                    curr = curr / 10;
                }
                if (!duplicate) {
                    total++;
                }
            }
            System.out.println(total);
        }
    }
}