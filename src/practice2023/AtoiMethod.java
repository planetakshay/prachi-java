package practice2023;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class AtoiMethod {

    public static void main(String[] args) {
        String s = "    -42";
        System.out.println("String to Integer: " + myAtoi(s));
        s = "-91283472332";
        System.out.println("String to Integer: " + myAtoi(s));
        s = "20000000000000000000";
        System.out.println("String to Integer: " + myAtoi(s));
    }

    public static int myAtoi(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        boolean isNegative = false;
        s = s.trim();
        if(s.startsWith("-")) {
            isNegative = true;
        }
        if(isNegative || s.startsWith("+")) {
            s = s.substring(1);
        }
        // Only use the digits and discard the rest of the string.
        StringBuilder onlyDigits = new StringBuilder();
        for(char ch: s.toCharArray()) {
            if(Character.isDigit(ch)) {
                onlyDigits.append(ch);
            } else {
                break;
            }
        }
        // Clamp down/up number if out of range.
        if(!onlyDigits.isEmpty()) {
            BigInteger bigNum = new BigInteger(onlyDigits.toString());
            if(isNegative) {
                bigNum = bigNum.negate();
            }
            if (bigNum.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) >= 0 ) {
                bigNum = bigNum.valueOf(Integer.MAX_VALUE);
            }
            if (bigNum.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) <= 0) {
                bigNum = bigNum.valueOf(Integer.MIN_VALUE);
            }
            return bigNum.intValue();
        } else {
            return 0;
        }
    }
}
