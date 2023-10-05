package practice2023;

/**
 * https://leetcode.com/problems/valid-number/description/
 */
public class ValidNumber {

    public static void main(String[] args) {
        System.out.println("null isValidNumber: " + isValidNumber(null));
        System.out.println("blank isValidNumber: " + isValidNumber(""));
        System.out.println("4.325 isValidNumber: " + isValidNumber("4.325"));
        System.out.println("-3.14 isValidNumber: " + isValidNumber("-3.14"));
        System.out.println("1.1.1 isValidNumber: " + isValidNumber("1.1.1"));
        System.out.println("28.prachi isValidNumber: " + isValidNumber("28.prachi"));
        System.out.println("prachi.deodhar isValidNumber: " + isValidNumber("prachi.deodhar"));
        System.out.println("something: " + isValidNumber("something"));

        System.out.println("something: " + isValid("0"));
    }

    public static boolean isValidNumber(String input) {
        if (input == null || input.isBlank()) {
            return false;
        }
        int periodCount = 0;
        for (char curr : input.toCharArray()) {
            if (periodCount > 1) {
                return false;
            }
            if (curr == '.') {
                periodCount++;
            } else if (curr != '-' && !Character.isDigit(curr)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(String s) {
        if (s == null || s.isBlank()) {
            return false;
        }
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;
        for (char curr : s.toCharArray()) {
            if (Character.isDigit(curr)) {
                seenDigit = true;
            } else if (curr == '-' || curr == '+') {
                int index = s.indexOf(curr);
                if (index > 0 && (s.charAt(index - 1) != 'e' || s.charAt(index - 1) != 'E')) {
                    return false;
                }
            } else if (curr == 'e' || curr == 'E') {
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false;
            } else if (curr == '.') {
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else {
                return false;
            }
        }
        return seenDigit;
    }
}
