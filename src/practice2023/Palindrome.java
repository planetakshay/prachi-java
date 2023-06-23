package practice2023;

public class Palindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Is string a palindrome: " + isValidPalindrome(s));
    }

    public static boolean isValidPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (Character.isLetter(chars[i])) {
                chars[j] = chars[i];
                j++;
            }
        }
        String onlyAlphabets = String.valueOf(chars).substring(0, j).toLowerCase();
        length = onlyAlphabets.length();
        int i = 0;
        j = length - 1;
        while (i <= length / 2 && j >= length / 2) {
            if (onlyAlphabets.charAt(i) != onlyAlphabets.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static String cleanupInput(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (Character.isLetter(chars[i]) || Character.isDigit(chars[i])) {
                chars[j] = chars[i];
                j++;
            }
        }
        return String.valueOf(chars).substring(0, j).toLowerCase();
    }

    public static boolean isPalindrome(String s) {
        int length = s.length();
        int i = 0, j = length - 1;
        while (i <= length / 2 && j >= length / 2) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}