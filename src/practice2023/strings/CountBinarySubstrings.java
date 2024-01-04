package practice2023.strings;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int ans = 0, prev = 0, curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                ans += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            } else {
                curr++;
            }
        }
        return ans + Math.min(prev, curr);
    }
}