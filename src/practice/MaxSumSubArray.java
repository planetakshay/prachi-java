package practice;

/**
 * Visit - http://rerun.me/blog/2012/08/30/maximum-continuous-subarray-problem-
 * Kadane's-algorithm/ for more details
 *
 * Best explanation is given on wikipedia page - https://en.wikipedia.org/wiki/Maximum_subarray_problem
 *
 * @author Prachi
 */
public class MaxSumSubArray {

    public static void main(String[] args) {

        int[] intArr = {-3, -1, -1, -1, -1, -1, -2, -5, -3, -2};
        maxSubArray(intArr);

        intArr = new int[]{-2, 1};
        maxSubArray(intArr);

        intArr = new int[]{-2, -1};
        maxSubArray(intArr);

        intArr = new int[]{-1, 0, -2};
        maxSubArray(intArr);

        intArr = new int[]{-3, -2, -2, -3};
        maxSubArray(intArr);

		intArr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		maxSubArray(intArr);
    }

    public static int maxSubArray(int[] nums) {

        int start = 0;
        int end = 0;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int maxStartIndex = 0;

        // In an array of +ve and -ve integers maximum sum
        // could be anything so choose a smallest number possible to begin
        // with. Hence Integer.MIN_VALUE.

        for (int i = 0; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            if (currSum > maxSum) {
                maxSum = Math.max(maxSum, currSum);
                start = maxStartIndex;
                end = i;
            } else if (currSum < 0) {
                maxStartIndex = i + 1;
                currSum = 0;
            }
        }
        System.out.println("Max sum         : " + maxSum);
        System.out.println("Max start index : " + start);
        System.out.println("Max end index   : " + end);
        return maxSum;
    }
}