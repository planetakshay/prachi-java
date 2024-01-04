package practice2023.recursion.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 */
public class CombinationSum3 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        LinkedList<Integer> combinations = new LinkedList<>();
        findCombinations(n, k, 0, combinations);
        return res;
    }
    private void findCombinations(int target, int k, int index, LinkedList<Integer> combinations) {
        int size = combinations.size();
        if (target == 0 && size == k) {
            res.add(new ArrayList<>(combinations));
            return;
        } else if (target < 0 || size == k) {
            return;
        }
        for (int i = index; i < 9; i++) {
            combinations.add(i + 1);
            findCombinations(target - (i + 1), k, i + 1, combinations);
            combinations.removeLast();
        }
    }
}