package practice2023.strings;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println("Longest palindromic substring: " + longestPalindrome(s));

        s = "cbbd";
        System.out.println("Longest palindromic substring: " + longestPalindrome(s));

        s = "babad";
        System.out.println("Longest palindromic substring: " + manacherAlgo(s));

        s = "cbbd";
        System.out.println("Longest palindromic substring: " + manacherAlgo(s));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.isBlank()) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int palindromeBegin = 0;
        int palindromeEnd = 0;

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                palindromeBegin = i;
                palindromeEnd = i + 1;
            }
        }

        for (int diff = 2; diff < len; diff++) {
            for (int i = 0; i < len - diff; i++) {
                int j = i + diff;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    palindromeBegin = i;
                    palindromeEnd = j;
                }
            }
        }
        return s.substring(palindromeBegin, palindromeEnd + 1);
    }

    public static String manacherAlgo(String s) {
        StringBuilder builder = new StringBuilder("|");
        for (char ch : s.toCharArray()) {
            builder.append(ch).append("|");
        }
        int newLen = builder.length();
        int[] paliRad = new int[newLen];
        int center = 0, radius = 0;

        for (int i = 0; i < newLen; i++) {
            int mirror = 2 * center - i;

            if (i < radius) {
                paliRad[i] = Math.min(radius - i, paliRad[mirror]);
            }

            while (i + 1 + paliRad[i] < newLen && i - 1 - paliRad[i] >= 0
                    && builder.charAt(i + 1 + paliRad[i]) == builder.charAt(i - 1 - paliRad[i])) {
                paliRad[i]++;
            }

            if (i + paliRad[i] > radius) {
                center = i;
                radius = i + paliRad[i];
            }
        }
        int maxLength = 0;
        int centerIndex = 0;
        for (int i = 0; i < newLen; i++) {
            if (paliRad[i] > maxLength) {
                maxLength = paliRad[i];
                centerIndex = i;
            }
        }
        int startIndex = (centerIndex - maxLength) / 2;
        return s.substring(startIndex, startIndex + maxLength);
    }
}