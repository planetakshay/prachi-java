package practice2023.strings;

/**
 *
 *  https://leetcode.com/problems/wildcard-matching/description/
 * https://walkccc.me/LeetCode/problems/0044/
 */
public class WildCardMatching {

    public static void main(String[] args) {
        WildCardMatching wildCardMatching = new WildCardMatching();
        String s = "aa";
        String p = "a*";
        System.out.println("is Matching: " + wildCardMatching.isMatch(s, p));

        s = "aa";
        p = "a";
        System.out.println("is Matching: " + wildCardMatching.isMatch(s, p));

        s = "ab";
        p = ".*";
        System.out.println("is Matching: " + wildCardMatching.isMatch(s, p));

        s = "aab";
        p = "c*a*b";
        System.out.println("is Matching: " + wildCardMatching.isMatchFaster(s, p));
    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;

        for (int i = 0; i < pLen; i++) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i];
            }
        }

        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < pLen; j++) {
                if (p.charAt(j) == '*') {
                    boolean matchEmpty = dp[i + 1][j];
                    boolean matchSome = dp[i][j + 1];
                    dp[i + 1][j + 1] = matchEmpty || matchSome;
                } else if (isMatch(s, i, p, j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        return dp[sLen][pLen];
    }

    public boolean isMatch(String s, int i, String p, int j) {
        return j >= 0 && (p.charAt(j) == '?' || p.charAt(j) == '.') ||
                s.charAt(i) == p.charAt(j);
    }

    public boolean isMatchFaster(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        int sIdx = 0, pIdx = 0;
        int starIdx = -1;
        int match = 0;
        while (sIdx < lenS) {
            if(pIdx < lenP && (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx)=='?')) {
                pIdx++;
                sIdx++;
            } else if (pIdx < lenP && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                match = sIdx;
                pIdx++;
            } else if (starIdx != -1) {
                pIdx = starIdx+1;
                match++;
                sIdx = match;
            } else {
                return false;
            }
        }
        while (pIdx < lenP && p.charAt(pIdx) == '*') {
            pIdx++;
        }
        return pIdx == lenP;
    }
}