package practice2023;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/zigzag-conversion/description/
public class ZigZagPattern {

    public static void main(String[] args) {
        System.out.println("String in ZigZag pattern: " + printZigZag("PAYPALISHIRING", 3));

        int equ = 5 - 7 * 3 % 5/2 * 14 + 9 % 4;
        System.out.println("equ: " + equ);
    }

    public static String printZigZag(String input, int numOfRows) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        Map<Integer, String> rows = new HashMap<>();
        int row = 1;
        boolean nextRow = true;

        for (int i = 0; i < input.length(); i++) {

            String existingValue = rows.getOrDefault(row, "");
            rows.put(row, existingValue + input.charAt(i));
            if (nextRow) {
                row++;
                if (row == numOfRows) {
                    nextRow = false;
                }
            } else {
                row--;
                if (row == 1) {
                    nextRow = true;
                }
            }
        }
        return String.join("", rows.values());
    }
}