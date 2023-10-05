package practice2023.map;

import java.util.HashMap;
import java.util.Map;

/**
 * letters in a word are scrambled in an input string.
 * We need to help user and autocorrect the word.
 */
public class AutoCorrectScrambledLetters {
    public static void main(String[] args) {
        String[] dictionary = new String[] {"duck, goose, gander"};
        AutoCorrectScrambledLetters wordMatching = new AutoCorrectScrambledLetters(dictionary);
    }
    Map<String, String> spellDiff;

    public String spellCheck(String input) {
        return spellDiff.getOrDefault(input, "");
    }

    public void populateSpellDiff(String[] dictionary) {
        for (String word : dictionary) {
            getPermutations(word);
        }
    }

    public void getPermutations(String word) {
        int len = word.length();
        for (int i = 0; i < len; i++) {
            String perm = "";
            int j = i + 1;
            while (j < len) {
                perm += word.charAt(j);
                j++;
            }
            spellDiff.put(perm, word);
        }
    }

    public AutoCorrectScrambledLetters(String[] dictionary) {
        spellDiff = new HashMap<>();
        populateSpellDiff(dictionary);
    }
}