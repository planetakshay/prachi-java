package practice2023.strings;

import java.util.Arrays;

/**
 * Leetcode easy problem.
 *
 * https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/
 */
public class StringParition {

    public static void main(String[] args) {
        String s = "abcdefghi";
        String[] partitions = divideString(s, 3, 'x');
        System.out.println("Partitions: " + Arrays.toString(partitions));

        s = "abcdefghij";
        partitions = divideString(s, 3, 'x');
        System.out.println("Partitions: " + Arrays.toString(partitions));

        s = "ctoyjrwtngqwt";
        partitions = divideString(s, 8, 'n');
        System.out.println("Partitions: " + Arrays.toString(partitions));
    }

    public static String[] divideString(String s, int k, char fill) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        int len = s.length();
        int size = 0;
        int quotient = len % k;
        if (quotient == 0) {
            size = s.length() / k;
        } else {
            size = s.length() / k + 1;
        }
        String[] partitions = new String[size];
        int index = 0;
        for (int i = 0; i < len; i += k) {
            int end = (i + k) > len ? (i + quotient) : i + k;
            String sub = s.substring(i, end);
            if ((k - sub.length()) > 0) {
                while (sub.length() < k) {
                    sub = sub + fill;
                }
            }
            partitions[index++] = sub;
        }
        return partitions;
    }
}
