package practice2023;

import java.util.Arrays;

/**
 *
 */
public class HeightChecker {

    public static void main(String[] args) {
        int[] height = new int[] {1,1,4,2,1,3};
        System.out.println("Students out of order: " + countBrokenOrder(height));
    }

    public static int countBrokenOrder(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int[] sortedHeight = new int[height.length];
        for(int i = 0; i < height.length;i++) {
            sortedHeight[i] = height[i];
        }
        Arrays.sort(sortedHeight);
        int outOfOrder = 0;
        for(int i=0; i<height.length;i++) {
            if(height[i] != sortedHeight[i]) {
                outOfOrder++;
            }
        }
        return outOfOrder;
    }
}
