package practice2023;

import java.util.Collections;
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
        Queue<Integer> uglyNumbers = new PriorityQueue<>(n, Collections.reverseOrder());

        uglyNumbers.add(1);

        int num = 2;
        boolean isUgly = false;
        while (uglyNumbers.size() < n) {
            if (num % 5 == 0) {
                num = num / 5;
                isUgly = true;
            } else if (num % 3 == 0) {
                num = num / 3;
                isUgly = true;
            } else if (num % 2 == 0) {
                num = num / 2;
                isUgly = true;
            }
            if (isUgly) {
                uglyNumbers.add(num);
            }
            num++;
        }

        return uglyNumbers.poll();
    }
}
