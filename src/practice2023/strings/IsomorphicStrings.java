package practice2023.strings;

import java.util.Arrays;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println("Is isomorphic: " + isIsomorphic(s, t));

        s = "add";
        t = "egg";
        System.out.println("Is isomorphic: " + isIsomorphic(s, t));

        s = "foo";
        t = "bar";
        System.out.println("Is isomorphic: " + isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        int[] sToT = new int[256];
        Arrays.fill(sToT, -1);
        int[] tToS = new int[256];
        Arrays.fill(tToS, -1);

        for (int i = 0; i < len; i++) {
            char si = s.charAt(i);
            char ti = t.charAt(i);
            if (sToT[si] == -1 && tToS[ti] == -1) {
                sToT[si] = ti;
                tToS[ti] = si;
            } else if (sToT[si] != ti || tToS[ti] != si) {
                return false;
            }
        }
        return true;
    }
}