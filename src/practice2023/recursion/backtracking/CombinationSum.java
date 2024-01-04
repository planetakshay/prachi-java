package practice2023.recursion.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 *
 */
public class CombinationSum {
    List<List<Integer>> res;
    int len = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        len = candidates.length;
        LinkedList<Integer> combinations = new LinkedList<>();
        findCombination(candidates, target, 0, combinations);
        return res;
    }

    private void findCombination(int[] candidates, int leftover, int index, LinkedList<Integer> combinations) {
        if (leftover == 0) {
            res.add(new ArrayList<>(combinations));
            return;
        }
        if (leftover < 0) {
            return;
        }
        for (int i = index; i < len; i++) {
            combinations.add(candidates[i]);
            findCombination(candidates, leftover - candidates[i], i, combinations);
            combinations.removeLast();
        }
    }
}