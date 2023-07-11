package practice2023.binarysearch;

/**
 * https://leetcode.com/problems/h-index-ii/
 * <p>
 * The constraint is the algorithm must be of O(logN).
 * Using binary search on a sorted array will help
 * achieve the time complexity constraint.
 */

public class HIndex {
    public static void main(String[] args) {
        int[] citations = new int[]{3, 0, 6, 1, 5};
        System.out.println("H-Index for given array: " + findHIndex(citations));

        citations = new int[]{1, 3, 1};
        System.out.println("H-Index for given array: " + findHIndex(citations));

        citations = new int[]{100};
        System.out.println("H-Index for given array: " + findHIndex(citations));
    }

    public static int findHIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int len = citations.length;
        int result = 0;
        for (int i = len - 1; i >= 0; i--) {
            int minRequired = len - i;
            if (citations[i] >= minRequired) {
                result = minRequired;
            }
        }
        return result;
    }
}