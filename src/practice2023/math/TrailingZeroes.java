package practice2023.math;

/**
 * Count num of trailing zero in
 * factorial of n.
 * 5! = 120 = 1
 * 10! = 3628800 = 2
 *
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 *
 */
public class TrailingZeroes {
    public int trailingZeroes(int n) {
        int zeroes = 0;
        while (n > 0) {
            n /= 5;
            zeroes += n;
        }
        return zeroes;
    }
}
