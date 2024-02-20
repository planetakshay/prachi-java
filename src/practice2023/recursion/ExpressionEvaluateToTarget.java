package practice2023.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Interview Kickstart Recurssion class Problem Set 1
 * <p>
 * <p>
 * Generate All Possible Expressions That Evaluate To The Given Target Value
 * <p>
 * Given a string s that consists of digits ("0".."9") and target, a non-negative integer, find all expressions that can be built from string s that evaluate to the target.
 * <p>
 * When building expressions, you have to insert one of the following operators between each pair of consecutive characters in s: join or * or +. For example, by inserting different operators between the two characters of string "12" we can get either 12 (1 joined with 2 or "12") or 2 ("1*2") or 3 ("1+2").
 * <p>
 * Other operators such as - or ÷ are NOT supported.
 * <p>
 * Expressions that evaluate to the target but only utilize a part of s do not count: entire s has to be consumed.
 * <p>
 * Precedence of the operators is conventional: join has the highest precedence, * – medium and + has the lowest precedence. For example, 1 + 2 * 34 = (1 + (2 * (34))) = 1 + 68 = 69.
 * <p>
 * You have to return ALL expressions that can be built from string s and evaluate to the target.
 * Example
 * <p>
 * {
 * "s": "202",
 * "target": 4
 * }
 * <p>
 * Output:
 * <p>
 * ["2+0+2", "2+02", "2*02"]
 */
public class ExpressionEvaluateToTarget {
    static List<String> results;
    static int len = 0;
    static List<String> generate_all_expressions(String s, Long target) {
        results = new ArrayList<>();
        len = s.length();
        getExpressions("", s, target, 0, 0L, 0L);
        return results;
    }
    static void getExpressions(String exp, String s, Long target, int offset, long expVal, long nextExpVal) {
        if (offset == len) {
            if (expVal == target) {
                results.add(exp);
            }
            return;
        }
        for (int i = offset; i < len; i++) {
            String numToAddStr = s.substring(offset, i + 1);
            long numToAdd = strToLong(numToAddStr);
            if (offset == 0) {
                getExpressions(numToAddStr, s, target, i + 1, numToAdd, numToAdd);
            } else {
                getExpressions(exp + '+' + numToAddStr, s, target, i + 1, expVal + numToAdd, numToAdd);
                getExpressions(exp + '*' + numToAddStr, s, target, i + 1, expVal - nextExpVal + (nextExpVal * numToAdd), nextExpVal * numToAdd);
            }
        }
    }
    static long strToLong(String str) {
        long val = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            val = val * 10L + (str.charAt(i) - '0');
        }
        return val;
    }
}