package practice2023.strings;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 * Leetcode Top 75.
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        if (s == null || s.isBlank()) {
            return s;
        }
        int len = s.length();
        int start = 0;
        int end = len - 1;
        char[] chs = s.toCharArray();

        while (start < end) {
            while (start < len && !isVowel(chs[start])) {
                start++;
            }

            while (end >= 0 && !isVowel(chs[end])) {
                end--;
            }

            if (start < end) {
                swap(chs, start, end);
            }
            start++;
            end--;
        }
        return new String(chs);
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
