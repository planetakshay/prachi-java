package practice2023.recursion.backtracking;

import java.util.ArrayList;

public class CombinationsWithSum {

    static Boolean checkIfSumPossible(ArrayList<Long> arr, Long k) {
        return helper(arr, k, 0, 0, false);
    }

    private static boolean helper(ArrayList<Long> arr, Long k, int index, long curr_sum, boolean foundInInput) {
        if (curr_sum == k && foundInInput) {
            return true;
        }
        if (index == arr.size()) {
            return false;
        }
        return helper(arr, k, index + 1, curr_sum, false)
                || helper(arr, k, index + 1, curr_sum + arr.get(index), true);
    }
}
