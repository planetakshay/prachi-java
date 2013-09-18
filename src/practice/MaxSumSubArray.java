package practice;

/**
 * Visit - http://rerun.me/blog/2012/08/30/maximum-continuous-subarray-problem-
 * kandanes-algorithm/ for more details
 * 
 * @author Prachi
 * 
 */
public class MaxSumSubArray {

	public static void main(String[] args) {

		int[] intArr = { -3, -1, -1, -1, -1, -1, -2, -5, -3, -2 };

		findMaxSubArray(intArr);
	}

	public static void findMaxSubArray(int[] inputArray) {

		int maxStartIndex = 0;
		int maxEndIndex = 0;
		int maxSum = Integer.MIN_VALUE; // In an array of
										// +ve and -ve integers maximum sum
										// could be anything so choose a
										// smallest number possible to begin
										// with. Hence
										// Integer.MIN_VALUE.

		int cumulativeSum = 0;
		int maxStartIndexUntilNow = 0;

		for (int currentIndex = 0; currentIndex < inputArray.length; currentIndex++) {

			int eachArrayItem = inputArray[currentIndex];

			cumulativeSum += eachArrayItem;

			if (cumulativeSum > maxSum) {
				maxSum = cumulativeSum;
				maxStartIndex = maxStartIndexUntilNow;
				maxEndIndex = currentIndex;
			} else if (cumulativeSum < 0) {
				maxStartIndexUntilNow = currentIndex + 1;
				cumulativeSum = 0;
			}
		}

		System.out.println("Max sum         : " + maxSum);
		System.out.println("Max start index : " + maxStartIndex);
		System.out.println("Max end index   : " + maxEndIndex);
	}
}