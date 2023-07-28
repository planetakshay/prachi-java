package practice2023.array;

import java.util.Arrays;

public class RunningSum {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4};
        System.out.println(Arrays.toString(runningSum(nums)));

        nums = new int[] {1,1,1,1,1};
        System.out.println(Arrays.toString(runningSum(nums)));

        nums = new int[] {3,1,2,10,1};
        System.out.println(Arrays.toString(runningSum(nums)));
    }

    public static int[] runningSum(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }
        int[] runningSum = new int[nums.length];
        for(int i= 0; i < nums.length; i++) {
            int sum = 0;
            for(int j=0; j <= i; j++) {
                sum += nums[j];
            }
            runningSum[i] = sum;
        }
        return runningSum;
    }

    public int[] runningSumDP(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] + nums[i];
        }
        return result;
    }
}
