package practice2023.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSum2 {
    List<List<Integer>> res;
    int len;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        len = candidates.length;
        LinkedList<Integer> combinations = new LinkedList<>();
        // Because we need to make sure that every repeating number is
        // used only onces.
        Arrays.sort(candidates);
        findCombinations(candidates, target, 0, combinations);
        return res;
    }

    private void findCombinations(int[] candidates, int target, int index, LinkedList<Integer> combinations) {

        if(target == 0) {
            res.add(new ArrayList<>(combinations));
            return;
        }
        for(int i = index; i< len; i++) {
            // To check repeating elements. Since the array is sorted before this call, repeating elements will appear
            //consecutively.
            if(i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            int curr = candidates[i];
            if(target - curr < 0) {
                break;
            }
            combinations.addLast(curr);
            findCombinations(candidates, target - curr, i + 1, combinations);
            combinations.removeLast();
        }
    }
}
