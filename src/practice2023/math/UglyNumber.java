package practice2023.math;

/**
 * https://leetcode.com/problems/ugly-number/description/
 *
 * Keep dividing the input number n by 2 until it cannot be further
 * divided by 2.
 * Repeat for 3 and 5.
 * If the input number's only prime factors are 2, 3 and 5 then
 * at the end of the process n will be 1. If not, number remaining
 * will be greater than 1.
 *
 * Return false for 0 and negative numbers as ugly number will be a
 * positive integer.
 */
public class UglyNumber {
    public boolean isUgly(int n) {
        if (n > 0) {
            int[] factors = {2, 3, 5};
            for (int i : factors) {
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        return n == 1;
    }
}