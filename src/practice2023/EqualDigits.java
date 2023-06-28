package practice2023;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class EqualDigits {

    public static void main(String[] args) {
        String num = "1210";
        System.out.println("Check for " + num + " : " + digitCount(num));

        num = "030";
        System.out.println("Check for " + num + " : " + digitCount(num));

        num = "0123";
        System.out.println("Check for " + num + " : " + digitCount(num));
    }

    public static boolean digitCount(String num) {
        int len = num.length();
        int[] limit = new int[10];
        for(char c : num.toCharArray()) {
            limit[c - '0']++;
        }
        for(int i = 0 ;i< len;i++) {
            if(limit[i] != (num.charAt(i) - '0')) {
                return false;
            }
        }
        return true;
    }
}
