package practice2023.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/baseball-game/
 */
public class BaseballGameRecords {
    public static void main(String[] args) {
        String[] operations = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println("Total score: " + calPoints(operations));
    }

    public static int calPoints(String[] operations) {
        List<Integer> records = new ArrayList<Integer>();
        int index = 0;
        for (String op : operations) {
            if (op.equals("+")) {
                int val1 = records.get(index - 2);
                int val2 = records.get(index - 1);
                records.add(index++, val1 + val2);
            } else if (op.equals("D")) {
                int val = records.get(index - 1);
                records.add(index++, val * 2);
            } else if (op.equals("C")) {
                records.remove(--index);
            } else {
                records.add(index++, Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (int num : records) {
            sum += num;
        }
        return sum;
    }
}