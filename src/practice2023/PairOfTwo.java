package practice2023;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * Linked-In phone screen.
 */
public class PairOfTwo {

    public static void main(String[] args) {
        int[] array = new int[]{3,4,5,6,7,8,9,10,12,13,11,2};
        System.out.println(findPairs(array, 100));
        array = new int[] {3,4,5,6,7,8,9,10,5,13,11,2};
        System.out.println(findPairs(array, 13));
    }

    /**
     * Store difference between the target sum and each array element
     * in a set. With every iteration check if the array element exists
     * in the difference (complement) set. That indicates the complement
     * of the current array element has been seen before and together those
     * numbers will yield the desired sum.
     *
     * The algorithm uses the concept of complements in arithmetic addition.
     * a + b = sum then sum - a = b
     *
     * @param array
     * @param val
     * @return
     */
    public static boolean findPairs(int[] array, int val) {
        Set<Integer> difference = new HashSet<>();
        for(int i : array) {
            if(difference.contains(i)) {
                return true;
            }
            // value should be greater than current array element.
            // hence deduct the array element from target sum.
            difference.add(val - i);
        }
        return false;
    }
}
