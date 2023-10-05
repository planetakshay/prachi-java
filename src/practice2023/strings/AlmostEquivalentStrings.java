package practice2023.strings;

/**
 * https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/description/
 */
public class AlmostEquivalentStrings {

    public static void main(String[] args) {
        String word1 = "abcdeef";
        String word2 = "abaaacc";
        System.out.println(word1 + " and " + word2 + " are almost equivalent: " + checkAlmostEquivalent(word1, word2));
    }

    public static boolean checkAlmostEquivalent(String word1, String word2) {
        int[] frequency = new int[26]; // Input has only lower case english alphabets.
        int len = word1.length(); // word1 and word2 are of same length.

        for (int i = 0; i < len; i++) {
            frequency[word1.charAt(i) - 'a']++;
            frequency[word2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < frequency.length; i++) {
            if (Math.abs(frequency[i]) > 3) {
                return false;
            }
        }
        return true;
    }
}