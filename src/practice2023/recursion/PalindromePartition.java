package practice2023.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * Covered in IK recursion problem sets
 *
 *
 */
public class PalindromePartition {
    List<List<String>> results;
    public List<List<String>> partition(String s) {
        results = new ArrayList<>();
        List<String> candidate = new ArrayList<>();
        helper(s, 0, candidate);
        return results;
    }

    private void helper(String s, int index, List<String> candidate) {
        int len = s.length();
        if(index >= len) {
            results.add(new ArrayList<>(candidate));
            return;
        }
        for(int i=index;i<len;i++) {
            if(isPalindrome(s, index, i)) {
                candidate.add(s.substring(index, i + 1));
                helper(s, i + 1, candidate);
                candidate.remove(candidate.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}