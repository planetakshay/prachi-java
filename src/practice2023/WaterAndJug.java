package practice2023;

/**
 * https://leetcode.com/problems/water-and-jug-problem/
 * As per water and jug problem explained in the Cracking the Coding Interview
 * if the capacity of the given jugs is relatively/mutually prime then
 * any quantity of water between 1 and the sum of capacity of two jugs
 * can be measured.
 *
 * Two mutually prime numbers will have their GCD as 1. Alternatively check if
 * either number is divisible by the other number.
 *
 * if targetCapacity is divisible by GCD of both jug capacity then also we can measure
 * the target capacity using both jugs.
 */
public class WaterAndJug {
    public static void main(String[] args) {
        int jug1 = 3;
        int jug2 = 5;
        int targetCapacity = 4;
        System.out.println(targetCapacity + " can be measured using given jugs: " + canMeasureWater(jug1, jug2, targetCapacity));

        jug1 = 2;
        jug2 = 6;
        targetCapacity = 5;
        System.out.println(targetCapacity + " can be measured using given jugs: " + canMeasureWater(jug1, jug2, targetCapacity));

        jug1 = 1;
        jug2 = 2;
        targetCapacity = 3;
        System.out.println(targetCapacity + " can be measured using given jugs: " + canMeasureWater(jug1, jug2, targetCapacity));

        jug1 = 6;
        jug2 = 4;
        targetCapacity = 8;
        System.out.println(targetCapacity + " can be measured using given jugs: " + canMeasureWater(jug1, jug2, targetCapacity));
    }
    public static boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        return targetCapacity % gcdByEuclidsAlgorithm(jug1Capacity, jug2Capacity) == 0
                && (1 <= targetCapacity && targetCapacity <= (jug1Capacity + jug2Capacity));
    }
    public static int gcdByBruteForce(int n1, int n2) {
        int gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
    public static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return true;
            }
        }
        return false;
    }
}
