package practice2023.strings;

public class PalindromicSubstring {
    int len = 0;

    public int countSubstrings(String s) {
        int count = 0;
        len = s.length();
        for (int i = 0; i < len; i++) {
            count += aroundCenter(s, i, i); // odd length
            count += aroundCenter(s, i, i + 1); // even length
        }
        return count;
    }

    private int aroundCenter(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < len) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start--;
            end++;
            count++;
        }
        return count;
    }
}
