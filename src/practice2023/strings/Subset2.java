package practice2023.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 * <p>
 * Covered in IK recursion practice set.
 */
public class Subset2 {
    List<List<Integer>> subsets;
    int len;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        subsets = new ArrayList<>();
        len = nums.length;
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return subsets;
    }

    private void helper(int[] nums, int offset, List<Integer> curr) {
        subsets.add(new ArrayList<>(curr));

        for (int i = offset; i < len; i++) {
            if (i != offset && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            helper(nums, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}