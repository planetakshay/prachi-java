package practice2023.strings;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sBuilder = performBackspace(s);
        StringBuilder tBuilder = performBackspace(t);
        return sBuilder.toString().contentEquals(tBuilder);
    }

    private StringBuilder performBackspace(String input) {
        StringBuilder builder = new StringBuilder();
        if (input == null || input.isEmpty()) {
            return builder;
        }
        char[] chars = input.toCharArray();
        for (char ch : chars) {
            if (ch != '#') {
                builder.append(ch);
            } else {
                int len = builder.length();
                if (len > 0) {
                    builder.deleteCharAt(len - 1);
                }
            }
        }
        return builder;
    }
}