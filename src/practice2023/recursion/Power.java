package practice2023.recursion;

/**
 * Covered in IK problem sets
 * https://leetcode.com/problems/powx-n/description/
 */
public class Power {
    public double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }
    private double binaryExp(double x, long n) {
        if(x == 0) {
            return 0.0;
        }
        if(x == 1 || n == 0) {
            return 1.0;
        }

        if(n < 0) {
            return 1.0 / binaryExp(x, -1 * n);
        }

        if(n % 2 == 1) {
            return x * binaryExp(x * x, (n-1) / 2);
        } else {
            return binaryExp(x * x, n / 2);
        }
    }
}
