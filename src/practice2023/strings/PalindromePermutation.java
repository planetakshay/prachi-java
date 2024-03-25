package practice2023.strings;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int len = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int odd = 0;
        for (int fr : freq) {
            odd += fr % 2;
        }
        return odd <= 1;
    }
}