package practice2023.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-primes/
 * <p>
 * Use https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes to solve
 * this problem as checking each prime number less than N is
 * extremely inefficient.
 *
 * Walmart contract position.
 */
public class CountPrimesLessThanN {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        /**
         * algorithm Sieve of Eratosthenes is
         *     input: an integer n > 1.
         *     output: all prime numbers from 2 through n.
         *
         *     let A be an array of Boolean values, indexed by integers 2 to n,
         *     initially all set to true.
         *
         *     for i = 2, 3, 4, ..., not exceeding √n do
         *         if A[i] is true
         *             for j = i2, i2+i, i2+2i, i2+3i, ..., not exceeding n do
         *                 set A[j] := false
         *
         *     return all i such that A[i] is true.
         */

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int total = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                total++;
            }
        }
        return total;
    }
}