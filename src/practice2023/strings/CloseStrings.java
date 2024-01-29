package practice2023.strings;

import java.util.Arrays;

public class CloseStrings {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return false;
        }
        int[] word1Freq = new int[26];
        int[] word2Freq = new int[26];
        for (char ch : word1.toCharArray()) {
            word1Freq[ch - 'a']++;
        }
        for (char ch : word2.toCharArray()) {
            word2Freq[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((word1Freq[i] == 0 && word2Freq[i] > 0) || (word1Freq[i] > 0 && word2Freq[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(word1Freq);
        Arrays.sort(word2Freq);
        return Arrays.equals(word1Freq, word2Freq);
    }
}