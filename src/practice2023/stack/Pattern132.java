package practice2023.stack;

import java.util.Stack;

public class Pattern132 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println("Pattern matches: " + findPattern132Stack(nums));

        nums = new int[]{3, 1, 4, 2};
        System.out.println("Pattern matches: " + findPattern132Stack(nums));

        nums = new int[]{-1, 3, 2, 0};
        System.out.println("Pattern matches: " + findPattern132Stack(nums));

        nums = new int[]{3, 5, 0, 3, 4};
        System.out.println("Pattern matches: " + findPattern132Stack(nums));

        nums = new int[]{1, 0, 1, -4, -3};
        System.out.println("Pattern matches: " + findPattern132Stack(nums));
    }

    public static boolean findPattern132(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 2] < nums[i] && nums[i - 1] > nums[i] && nums[i - 2] < nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean findPattern132Stack(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[len];
        min[0] = nums[0];
        for(int j=1; j < len; j++) {
            min[j] = Math.min(min[j - 1], nums[j]);
        }
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] > min[i]) {
                while (!stack.isEmpty() && stack.peek() <= min[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
