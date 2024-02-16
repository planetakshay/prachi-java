package practice2023.strings;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */
public class AdjacentDuplicates {
    public String removeDuplicates(String s, int k) {
        StringBuilder builder = new StringBuilder(s);
        Stack<Integer> count = new Stack<>();
        for (int i = 0; i < builder.length(); i++) {
            if (i == 0 || builder.charAt(i) != builder.charAt
                    (i - 1)) {
                count.push(1);
            } else {
                int num = count.pop() + 1;
                if (num == k) {
                    builder.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    count.push(num);
                }
            }
        }
        return builder.toString();
    }
}