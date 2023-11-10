package practice2023.strings;

/**
 * https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/
 */
public class SpecialTypeWriter {
    public int minTimeToType(String word) {
        int pointer = 0;
        int total = word.length(); // time to print all characters.
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int location = word.charAt(i) - 'a';
            int distance = Math.abs(location - pointer);
            total += Math.min(distance, 26 - distance);
            pointer = location;
        }
        return total;
    }
}