package practice2023.strings;

/**
 * https://leetcode.com/problems/merge-strings-alternately/
 */
public class MergeAlternatively {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        // System.out.println("Merged string: " + mergeAlternately(word1, word2));

        word1 = "ab";
        word2 = "pqrs";
        System.out.println("Merged string: " + mergeAlternately(word1, word2));
    }
    public static String mergeAlternately(String word1, String word2) {
        if(word1 == null) {
            return word2;
        } else if(word2 == null) {
            return word1;
        }
        int len = Math.min(word1.length(), word2.length());
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<len;i++) {
            builder.append(word1.charAt(i));
            builder.append(word2.charAt(i));
        }
        String remaining = word1.length() > len ? word1 : word2;
        for(int i = len;i < remaining.length();i++) {
            builder.append(remaining.charAt(i));
        }
        return builder.toString();
    }
}
