package practice2023.strings;

public class Pangram {
    static final String PANGRAM = "pangram";
    static final String NOT = "not ";

    public static String pangrams(String s) {
        if (s == null || s.length() < 26) {
            return NOT + PANGRAM;
        }
        int len = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != ' ') {
                int val = Character.toLowerCase(s.charAt(i)) - 'a';
                freq[val]++;
            }
        }
        for (int count : freq) {
            if (count < 1) {
                return NOT + PANGRAM;
            }
        }
        return PANGRAM;
    }
}