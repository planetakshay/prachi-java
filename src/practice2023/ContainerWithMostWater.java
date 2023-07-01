package practice2023;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println("Container with maximum water: " + maxArea(height));
    }
    public static int maxArea(int[] height) {
        int maxArea = 0;
        if (height == null || height.length < 2) {
            return maxArea;
        } else {
            int asc = 0;
            int desc = height.length - 1;
            while (asc < desc) {
                int currH = 0;
                int currW = desc - asc;
                if (height[asc] < height[desc]) {
                    currH = height[asc];
                    maxArea = Math.max(maxArea, (currH * currW));
                    asc++;
                } else {
                    currH = height[desc];
                    maxArea = Math.max(maxArea, (currH * currW));
                    desc--;
                }
            }
            return maxArea;
        }
    }
}
