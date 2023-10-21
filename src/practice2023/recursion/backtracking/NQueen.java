package practice2023.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/description/
 * <p>
 * Covered in IK recursion live class.
 */
public class NQueen {
    List<List<String>> results;

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        List<List<String>> results = nQueen.solveNQueens(4);
        System.out.println(results);
    }

    public List<List<String>> solveNQueens(int n) {
        results = new ArrayList<>();
        List<Integer> state = new ArrayList<>();
        helper(n, 0, state);
        return results;
    }

    private void helper(int n, int row, List<Integer> state) {
        if (!valid(state)) {
            return;
        }
        if (row == n) {
            char[] temp = new char[n];
            Arrays.fill(temp, '.');
            List<String> arrangement = new ArrayList<>();
            for (int i = 0; i < state.size(); i++) {
                temp[state.get(i)] = 'Q';
                arrangement.add(new String(temp));
                Arrays.fill(temp, '.');
            }
            results.add(new ArrayList<>(arrangement));
            return;
        }

        for (int col = 0; col < n; col++) {
            state.add(col);
            helper(n, row + 1, state);
            // remove the last element inserted.
            state.remove(state.size() - 1);
        }
    }

    private boolean valid(List<Integer> slate) {
        if (slate.size() < 2) {
            return true;
        }
        int last = slate.size() - 1;
        for (int i = 0; i < last; i++) {
            if (slate.get(i).equals(slate.get(last))) {
                return false;
            }
            // To check if the queens are placed diagonally
            // compute the slope using x and y axis formula.
            // For two points to be on the same line, their
            // difference of respective x axis and y axis will
            // same.
            if (Math.abs(slate.get(i) - slate.get(last)) == Math.abs(i - last)) {
                return false;
            }
        }
        return true;
    }
}