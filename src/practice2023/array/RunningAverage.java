package practice2023.array;

import java.util.Arrays;

/**
 * Career cup website
 */
public class RunningAverage {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(computeAverage(new int[]{1, 2 ,3})));
    }
    public static double[] computeAverage(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        double[] average = new double[len];
        int sum = 0;
        for(int i=0; i < len; i++) {
            sum += nums[i];
            average[i] =  ((double) sum / (i + 1));
        }
        return average;
    }
}
