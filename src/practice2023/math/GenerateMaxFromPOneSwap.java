package practice2023.math;

public class GenerateMaxFromPOneSwap {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int digit = 9; digit > digits[i] - '0'; digit--) {
                if (last[digit] > i) {
                    char temp = digits[i];
                    digits[i] = digits[last[digit]];
                    digits[last[digit]] = temp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}