package practice2023.math;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 * <p>
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * <p>
 * Given an integer n, return the nth ugly number.
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(n + "th Ugly Number: " + nthUglyNumber(n));
        n = 11;
        System.out.println(n + "th Ugly Number: " + nthUglyNumber(n));
    }
    public static int nthUglyNumber(int n) {
        if (n == 1) {
            return n;
        }
        Queue<Long> uglyNumbers = new PriorityQueue<>();
        int[] factors = {2, 3, 5};
        Long ugly = 1L;
        uglyNumbers.offer(ugly);
        for (int i = 0; i < n; i++) {
            ugly = uglyNumbers.poll();
            for (int j : factors) {
                long num = ugly * j;
                if (!uglyNumbers.contains(num)) {
                    uglyNumbers.offer(num);
                }
            }
        }
        return ugly.intValue();
    }
}