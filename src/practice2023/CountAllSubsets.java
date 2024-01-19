package practice2023;

/**
 * right shift operation of the number n with 1 will
 * give 2 raised to the power of number n. Which is
 * no of subset of a set with n elements.
 *
 * Covered in IK foundation material for recurssion.
 */
public class CountAllSubsets {
    public static void main(String[] args) {
        long n = 100;
        System.out.println(countSubsets(n));
    }

    public static long countSubsets(long n) {
        return 1 << n;
    }
}
