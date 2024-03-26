package practice2023.array;

/**
 * https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        boolean[] found = new boolean[len + 1];

        for (int num : nums) {
            if (num > 0 && num <= len) {
                found[num] = true;
            }
        }
        int i = 1;
        while (i <= len) {
            if (!found[i]) {
                return i;
            }
            i++;
        }
        return i;
    }
}