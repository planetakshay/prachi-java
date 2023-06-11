package practice2023;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{1, 9, 9};
        Arrays.stream(plusOne(digits)).forEach(n -> {
            System.out.print("\t" + n);
        });
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] sum = new int[digits.length + 1];
        sum[0] = 1;
        return sum;
    }
}