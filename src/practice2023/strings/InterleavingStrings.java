package practice2023.strings;

public class InterleavingStrings {

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println("Is interleaving string of s1 & s2: " + isInterleave(s1, s2, s3));

        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbbaccc";
        System.out.println("Is interleaving string of s1 & s2: " + isInterleave(s1, s2, s3));

        s1 = "";
        s2 = "";
        s3 = "";
        System.out.println("Is interleaving string of s1 & s2: " + isInterleave(s1, s2, s3));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        boolean isInterleaving = false;
        // If length of s3 isn't equal to s1.length + s2.length;
        if (s1 == null || s2 == null || s3 == null) {
            return isInterleaving;
        }
        int s1Len = s1.length();
        int s2Len = s2.length();
        int s3Len = s3.length();

        if (s1Len + s2Len != s3Len) {
            return isInterleaving;
        }
        // initialize memoization datastructure.
        int[][] memo = new int[s1Len][s2Len];
        for (int i = 0; i < s1Len; i++) {
            for (int j = 0; j < s2Len; j++) {
                memo[i][j] = -1;
            }
        }
        return isInterleaving(s1, 0, s2, 0, s3, 0, memo);
    }

    public static boolean isInterleaving(String s1, int i, String s2, int j, String s3, int k, int[][] memo) {
        if (i == s1.length()) {
            return s2.substring(j).equalsIgnoreCase(s3.substring(k));
        }
        if (j == s2.length()) {
            return s1.substring(i).equalsIgnoreCase(s3.substring(k));
        }
        if (memo[i][j] >= 0) {
            return memo[i][j] == 1;
        }
        boolean isInterleaving = false;
        if (s3.charAt(k) == s1.charAt(i) && isInterleaving(s1, i + 1, s2, j, s3, k + 1, memo)
                || s3.charAt(k) == s2.charAt(j) && isInterleaving(s1, i, s2, j + 1, s3, k + 1, memo)) {
            isInterleaving = true;
        }
        memo[i][j] = isInterleaving ? 1 : 0;
        return isInterleaving;
    }
}
