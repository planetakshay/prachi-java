package practice2023.stack;

import java.util.Stack;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Maximum " + trap(height) + " units of rain water can be trapped");

        height = new int[]{4,2,0,3,2,5};
        System.out.println("Maximum " + trap(height) + " units of rain water can be trapped");
    }

    public static int trap(int[] height) {
        int water = 0;
        if (height == null || height.length == 0) {
            return water;
        }
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        int len = height.length;
        while (curr < len) {
            while (!stack.isEmpty() && height[curr] > height[stack.peek()]) {
                int top = stack.peek();
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int dist = curr - stack.peek() - 1;
                int bounded = Math.min(height[curr], height[stack.peek()]) - height[top];
                water += dist * bounded;
            }
            stack.push(curr++);
        }
        return water;
    }
}