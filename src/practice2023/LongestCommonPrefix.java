package practice2023;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Find longest common prefix in the given strings
 *
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println("Longest Common Prefix: " + getLongestCommonPrefix(strs));

        strs = new String[]{"dog","racecar","car"};
        System.out.println("Longest Common Prefix: " + getLongestCommonPrefix(strs));
    }

    public static String getLongestCommonPrefix(String[] strs) {
        String prefix = "";

        if(strs == null || strs.length < 1) {
            return prefix;
        }
        prefix = strs[0];
        for(int i=1;i< strs.length;i++) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
