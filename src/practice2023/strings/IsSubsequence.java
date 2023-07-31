package practice2023.strings;

/**
 * https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * Uses two pointers technique.
 */
public class IsSubsequence {
    public static void main(String[] args) {
        String s = "ace";
        String t = "ahcde";
        System.out.println("Is Subsequence: " + isSubsequence(s, t));

        s = "aaa";
        t = "acccaddda";
        System.out.println("Is Subsequence: " + isSubsequence(s, t));

        s= "axc";
        t = "ahbgdc";
        System.out.println("Is Subsequence: " + isSubsequence(s, t));
    }
    public static boolean isSubsequence(String s, String t) {
        int leftBound = s.length();
        int rightBound = t.length();
        int left = 0, right = 0;
        while(left < leftBound && right < rightBound) {
            if(s.charAt(left) == t.charAt(right)) {
                left++;
            }
            right++;
        }
        return left == leftBound;
    }
}
