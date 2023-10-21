package practice2023.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate All Subsets Of A Set
 * <p>
 * Generate ALL possible subsets of a given set. The set is given in the form of a string s containing distinct lowercase characters 'a' - 'z'.
 */
public class AllSubSetsOfASet {
    static List<String> generateAllSubsets(String s) {
        // Write your code here.
        List<String> results = new ArrayList<>();
        helper(s, 0, "", results);
        return results;
    }

    private static void helper(String s, int index, String slate, List<String> results) {
        if (index == s.length()) {
            results.add(slate);
            return;
        }
        helper(s, index + 1, slate, results);
        helper(s, index + 1, slate + s.charAt(index), results);
    }
}