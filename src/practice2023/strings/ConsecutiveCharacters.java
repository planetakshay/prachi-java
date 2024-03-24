package practice2023.strings;

/**
 * https://leetcode.com/problems/consecutive-characters/
 */
public class ConsecutiveCharacters {
    public int maxPower(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int i = 1;
        int j = s.length();
        int power = 0;
        int count = 1;
        while (i < j) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
            } else {
                power = Math.max(count, power);
                count = 1;
            }
            i++;
        }
        return Math.max(power, count);
    }
}