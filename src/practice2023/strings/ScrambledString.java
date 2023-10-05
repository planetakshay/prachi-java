package practice2023.strings;

import java.util.Arrays;

public class ScrambledString {

    public boolean isScramble(String s1, String s2) {
        char[] charS1 = s1.toCharArray();
        char[] charS2 = s2.toCharArray();

        Arrays.sort(charS1);
        Arrays.sort(charS2);

        int len = s1.length();
        for(int i=0;i < len; i++) {
            if(charS1[i] != charS2[i]) {
                return false;
            }
        }
        return true;
    }
}
