package practice2023.strings;

/**
 * https://leetcode.com/problems/break-a-palindrome/description/
 * <p>
 * We need to make the string non-palindromic by editing exactly one
 * character so that the resulting string is not a palindrome
 * and is lexicographically smallest of all possibilities.
 * <p>
 * The string has only lowercase english alphabets.
 * <p>
 * As the problem statement suggests. we only want to change a letter
 * with 'a' to make it non-palindrome. We traverse through half the
 * string and replace a character that is not already 'a' and return the
 * edited string.
 * <p>
 * If after traversing half the string, we still have not replaced a letter with
 * 'a' that means input string consists of only 'a's (remember that we have already
 * traversed half the string and that the string is a palindrome.) and hence
 * replace the last letter with character 'b'. Now you have a non-palindromic string
 * which is lexicographically smallest among all such possibilities.
 */
public class MakeNonPalindrome {

    public static void main(String[] args) {

    }

    public String breakPalindrome(String palindrome) {
        if (palindrome == null || palindrome.length() <= 1) {
            return "";
        }
        char[] chars = palindrome.toCharArray(); // Since String is immutable use charArray
        int limit = chars.length / 2; // We only need half the string.
        for (int i = 0; i < limit; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return String.valueOf(chars);
            }
        }
        chars[chars.length - 1] = 'b';
        return String.valueOf(chars);
    }
}