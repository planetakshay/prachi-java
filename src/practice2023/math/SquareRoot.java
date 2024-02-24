package practice2023.math;

/**
 * https://leetcode.com/problems/sqrtx/
 * <p>
 * The problem states solve without using inbuilt library functions
 * The solution uses Binary Search.
 */
public class SquareRoot {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        long num = 0L;
        int pivot = 0, left = 2, right = x / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long) pivot * pivot;
            if (num == x) {
                return pivot;
            } else if (num > x) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return right;
    }
}