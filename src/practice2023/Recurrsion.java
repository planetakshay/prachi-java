package practice2023;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-case-permutation/submissions/
 * <p>
 * This problem was covered in the InterviewKickstart recurssion session.
 * <p>
 * n = input string length
 * Time Complexity: 2 raised to the power n * n
 * Space Complexity: 2 raised to the power n * n (explicit memory)
 * (implicit memory) O(n squared)
 * because of the string immutability at every recursive
 * step the size of the sub will grow like 0, 1, 2, 3 up to
 * n. which is n(n+1) / 2 which is O(N squared)
 * <p>
 * to improve the space complexity (implicit memory) use array.
 */
public class Recurrsion {
    List<String> results;
    public List<String> letterCasePermutation(String s) {
        results = new ArrayList<>();
        int len = s.length();
        char[] sub = new char[len];
        helper(s, 0, len, sub);
        return results;
    }
    public void helper(String s, int index, int len, char[] sub) {
        if (index == len) {
            results.add(new String(sub));
            return;
        }
        char curr = s.charAt(index);
        if (Character.isDigit(curr)) {
            sub[index] = curr;
            helper(s, index + 1, len, sub);
            sub[index] = '\u0000';
        } else {
            sub[index] = Character.toLowerCase(curr);
            helper(s, index + 1, len, sub);
            sub[index] = '\u0000';

            sub[index] = Character.toUpperCase(curr);
            helper(s, index + 1, len, sub);
            sub[index] = '\u0000';
        }
    }
}