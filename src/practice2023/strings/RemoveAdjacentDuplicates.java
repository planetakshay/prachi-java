package practice2023.strings;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
 */
public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println("After duplicate removal: " + removeDuplicatesEff(s));
    }
    public static String removeDuplicates(String s) {
        int length = s.length();
        int index = 0;
        while (length > 1 && index < length - 1) {
            if (s.charAt(index) == s.charAt(index + 1)) {
                if (index > 0) {
                    s = s.substring(0, index) + s.substring(index + 2);
                } else {
                    s = s.substring(index + 2);
                }
                length = s.length();
                index = 0;
            } else {
                index++;
            }
        }
        return s;
    }

    public static String removeDuplicatesEff(String s) {
        StringBuilder builder = new StringBuilder();
        int len = builder.length();

        for(char ch : s.toCharArray()) {
            if(len != 0 && ch == builder.charAt(len - 1)) {
                builder.deleteCharAt(len - 1);
                len--;
            } else {
                builder.append(ch);
                len++;
            }
        }
        return builder.toString();
    }
}