package practice2023;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "empty string";
        System.out.println("Edit distance: " + calculateRecursive(s1, s2));

        s1 = "empty";
        s2 = "string";
        System.out.println("Edit distance: " + calculateRecursive(s1, s2));

        s1 = "global";
        s2 = "globla";
        System.out.println("Edit distance: " + calculateRecursive(s1, s2));

        s1 = "practice";
        s2 = "practical";
        System.out.println("Edit distance: " + calculateRecursive(s1, s2));

        s1 = "pale";
        s2 = "tale";
        System.out.println("Is one edit away: " + isOneEditAway(s1, s2));

        // Using dynamic programming
        System.out.println("\nDynamic Programing approach....");
        s1 = "global";
        s2 = "globla";
        System.out.println("Edit distance: " + calculateDynamicProgramming(s1, s2));

        s1 = "practice";
        s2 = "practical";
        System.out.println("Edit distance: " + calculateDynamicProgramming(s1, s2));
    }

    public static int calculateRecursive(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return 1;
        }
        if (s1.length() == 0) {
            return s2.length();
        }
        if (s2.length() == 0) {
            return s1.length();
        }
        // Calculate cost of each edit. For substitution, it will be either 0 or 1.
        // For insertion and deletion the cost is 1.
        int substitute = calculateRecursive(s1.substring(1), s2.substring(1)) + costOfSubstitution(s1.charAt(0), s2.charAt(0));
        int insert = calculateRecursive(s1.substring(1), s2) + 1;
        int delete = calculateRecursive(s1, s2.substring(1)) + 1;
        return minimum(substitute, insert, delete);
    }

    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static int minimum(int... nums) {
        return Arrays.stream(nums).min().orElse(Integer.MAX_VALUE);
    }

    public static boolean isOneEditAway(String s1, String s2) {
        int dist = calculateRecursive(s1, s2);
        return dist == 1 ? true : false;
    }

    public static int calculateDynamicProgramming(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return 1;
        }
        int s1Len = s1.length();
        int s2Len = s2.length();
        int[][] dp = new int[s1Len + 1][s2Len + 1];

        for (int i = 0; i <= s1Len; i++) {
            for (int j = 0; j <= s2Len; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int substitute = dp[i - 1][j - 1] + costOfSubstitution(s1.charAt(i - 1), s2.charAt(j - 1));
                    int insert = dp[i - 1][j] + 1;
                    int delete = dp[i][j - 1] + 1;
                    dp[i][j] = minimum(substitute, insert, delete);
                }
            }
        }
        return dp[s1Len][s2Len];
    }
}
