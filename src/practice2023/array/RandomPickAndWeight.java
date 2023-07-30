package practice2023.array;

/**
 * https://leetcode.com/problems/random-pick-with-weight/description/
 */
public class RandomPickAndWeight {
    private int[] prefixSum;
    private int totalSum;

    public RandomPickAndWeight(int[] w) {
        this.prefixSum = new int[w.length];

        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            this.prefixSum[i] = prefixSum;
        }
        this.totalSum = prefixSum;
    }

    public int pickIndex() {
        double target = this.totalSum * Math.random();
        int i = 0;
        // run a linear search to find the target zone
        for (; i < this.prefixSum.length; ++i) {
            if (target < this.prefixSum[i])
                return i;
        }
        // to have a return statement, though this should never happen.
        return i - 1;
    }
}
