package practice2023.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * <p>
 * covered in IK recursion practice set.
 */
public class PhNumberToStrings {
    private final Map<Character, String> letters = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    List<String> ans;
    int len;

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return ans;
        }
        digits = digits.replace("0", "").replace("1", "");
        len = digits.length();
        if (len == 0) {
            return ans;
        }
        words(digits, 0, new StringBuilder());
        return ans;
    }

    private void words(String digits, int offset, StringBuilder builder) {
        if (builder.length() == digits.length()) {
            ans.add(builder.toString());
            return;
        }
        String mapped = letters.get(digits.charAt(offset));
        for (char ch : mapped.toCharArray()) {
            builder.append(ch);
            words(digits, offset + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}