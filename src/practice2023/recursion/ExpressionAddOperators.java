package practice2023.recursion;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    int target;
    String digits;
    List<String> ans;

    public List<String> addOperators(String num, int target) {
        ans = new ArrayList<>();
        if (num.length() == 0) {
            return ans;
        }
        this.target = target;
        this.digits = num;
        findExpression(0, 0, 0, 0, new ArrayList<>());
        return ans;
    }

    private void findExpression(int index, long prev, long curr, long value, List<String> ops) {
        String nums = this.digits;

        if (index == nums.length()) {
            if (value == this.target && curr == 0) {
                StringBuilder builder = new StringBuilder();
                ops.subList(1, ops.size()).forEach(v -> builder.append(v));
                this.ans.add(builder.toString());
            }
            return;
        }

        curr = curr * 10 + Character.getNumericValue(nums.charAt(index));
        String currVal = String.valueOf(curr);
        int len = nums.length();

        if (curr > 0) {
            findExpression(index + 1, prev, curr, value, ops);
        }

        ops.add("+");
        ops.add(currVal);
        findExpression(index + 1, curr, 0, value + curr, ops);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);

        if (ops.size() > 0) {
            ops.add("-");
            ops.add(currVal);
            findExpression(index + 1, -curr, 0, value - curr, ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);

            ops.add("*");
            ops.add(currVal);
            findExpression(index + 1, curr * prev, 0, value - prev + (curr * prev), ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);
        }
    }

    public List<String> addOperatorsBfs(String num, int target) {
        return null;
    }
}