package practice2023.strings;

/**
 * https://leetcode.com/problems/valid-word-abbreviation/
 */
public class WordAbbriviation {

    public static void main(String[] args) {
        System.out.println(validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(validWordAbbreviation("internationalization", "i18n"));
        System.out.println(validWordAbbreviation("apple", "a2e"));
        System.out.println(validWordAbbreviation("internationalization", "bbc"));
    }
    public static boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || abbr == null) {
            return false;
        }
        int wLen = word.length();
        int aLen = abbr.length();
        if (aLen > wLen) {
            return false;
        }
        if (wLen == 0) {
            return true;
        }

        int i = 0;
        int j = 0;

        while (i < wLen && j < aLen) {
            char wChar = word.charAt(i);
            char aChar = abbr.charAt(j);
            if (wChar == aChar) {
                i++;
                j++;
                continue;
            }
            if (aChar == '0' || !Character.isDigit(aChar)) {
                return false;
            }
            int num = 0;
            while (j < aLen && Character.isDigit(abbr.charAt(j))) {
                num = 10 * num + (abbr.charAt(j) - '0');
                j++;
            }
            i += num;
        }
        return i == wLen && j == aLen;
    }
}