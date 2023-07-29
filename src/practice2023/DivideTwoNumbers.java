package practice2023;

public class DivideTwoNumbers {

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        System.out.println("Divide 10 by 3: " + divide(dividend, divisor));

        dividend = 7;
        divisor = -3;
        System.out.println("Divide 7 by -3: " + divide(dividend, divisor));
    }
    public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int negative=0;
        if(divisor <= 0) {
            negative++;
            divisor = -divisor;
        }
        if(dividend <= 0) {
            negative++;
            dividend = -dividend;
        }
        int substraction = 0;
        while(dividend - divisor >= 0) {
            dividend -= divisor;
            substraction++;
        }
        if(negative == 1) {
            substraction = -substraction;
        }
        return substraction;
    }
}
