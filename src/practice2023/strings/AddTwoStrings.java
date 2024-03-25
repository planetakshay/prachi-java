package practice2023.strings;

/**
 * https://leetcode.com/problems/add-strings/
 */
public class AddTwoStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int op1 = i >= 0 ? Character.getNumericValue(num1.charAt(i)) : 0;
            int op2 = j >= 0 ? Character.getNumericValue(num2.charAt(j)) : 0;

            int sum = carry + op1 + op2;
            carry = sum / 10;
            builder.append(sum % 10);
            i--;
            j--;
        }
        if (carry > 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }
}