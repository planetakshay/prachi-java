package practice2023.strings;

/**
 * https://leetcode.com/problems/reorganize-string/description/
 */
public class ReorganizeString {
    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        String s = "aab";
        System.out.println("Rearranged String: " + reorganizeString.reorganizeString(s));

        s = "aaab";
        System.out.println("Rearranged String: " + reorganizeString.reorganizeString(s));
    }

    public String reorganizeString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        // The string s will only have lowercase english alphabets.
        int[] frequencies = new int[26];
        char mostFreq = '\u0000';
        int freqIndex = -1;
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int curr = s.charAt(i) - 'a';
            frequencies[curr] += 1;
            if (max < frequencies[curr]) {
                max = frequencies[curr];
                freqIndex = curr;
            }
        }
        // We need max frequency, at the most half (rounded up) of the string's length
        // or else it cannot generate a string conforming to the rearrangement
        // requirements.

        if (max > (len + 1) / 2) {
            return "";
        }
        // Start with placing most frequently character at even indices;
        int i = 0;
        char[] ans = new char[len];
        while (frequencies[freqIndex] != 0) {
            ans[i] = (char) (freqIndex + 'a');
            i += 2;
            frequencies[freqIndex]--;
        }
        // Place remaining characters;

        for (int j = 0; j < frequencies.length; j++) {
            while (frequencies[j] > 0) {
                if (i >= len) {
                    i = 1;
                }
                ans[i] = (char) (j + 'a');
                i += 2;
                frequencies[j]--;
            }
        }
        return String.valueOf(ans);
    }
}