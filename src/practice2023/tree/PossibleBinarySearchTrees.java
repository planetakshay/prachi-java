package practice2023.tree;

/**
 * Part of IK practice tests for recursion.
 *
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class PossibleBinarySearchTrees {
    static Long howManyBsts(Integer n) {
        if (n == 0) {
            return 1L;
        }
        long total = 0L;
        for (int left = 0; left < n; left++) {

            int right = n - 1 - left;
            total += howManyBsts(left) * howManyBsts(right);
        }
        return total;
    }
}