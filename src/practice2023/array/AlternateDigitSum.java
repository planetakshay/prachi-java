package practice2023.array;

/**
 * https://leetcode.com/problems/alternating-digit-sum/description/
 */
public class AlternateDigitSum {
    public static void main(String[] args){
        System.out.println("Digit sum: " + alternateDigitSum(521));
        System.out.println("Digit sum: " + alternateDigitSum(111));
        System.out.println("Digit sum: " + alternateDigitSum(886996));
        System.out.println("Digit sum: " + alternateDigitSum(10));
    }
    public static int alternateDigitSum(int n) {
        if(n <= 0) {
            return 0;
        }
        int reverse = 0;
        int digit = 0;
        while(n > 0) {
            digit = n % 10;
            reverse = reverse * 10 + digit;
            n = n / 10;
        }
        int sum = 0;
        boolean shouldAdd = true;
        while(reverse > 0) {
            digit = reverse % 10;
            if(shouldAdd) {
                sum += digit;
            } else {
                sum -= digit;
            }
            reverse = reverse / 10;
            shouldAdd = !shouldAdd;
        }
        return sum;
    }
}