package practice2023.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies/description/
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int sLength = s.length;
        int gLength = g.length;
        while (i < sLength && j < gLength) {
            if (s[i] >= g[j]) {
                j++;
            }
            i++;
        }
        return j;
    }
}
