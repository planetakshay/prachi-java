package practice2023.recursion;

import java.util.ArrayList;

/**
 * Covered in IK recursion and backtracking class.
 * Following solution uses recursion and backtracking both.
 */
public class WelformedParentheses {

    static ArrayList<String> find_all_well_formed_brackets(Integer n) {
        ArrayList<String> results = new ArrayList<>();
        StringBuilder slate = new StringBuilder();
        helper(n, 0, 0, slate, results);
        return results;
    }

    static void helper(int n, int l, int r, StringBuilder slate, ArrayList<String> results) {
        if(r > l || l > n) {
            return;
        }
        if(l == n && r == n) {
            results.add(slate.toString());
            return;
        }

        slate.append("(");
        helper(n, l + 1, r, slate, results); // Increment count for left parentheses.
        slate.deleteCharAt(slate.length() - 1);

        slate.append(")");
        helper(n, l, r + 1, slate, results);
        slate.deleteCharAt(slate.length() - 1);
    }
}