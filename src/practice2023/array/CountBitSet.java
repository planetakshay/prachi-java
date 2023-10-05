package practice2023.array;

/**
 * https://leetcode.com/problems/counting-bits/
 *
 */
public class CountBitSet {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for(int i=0; i<= n; i++) {
            // ans[i] = findWeight(i);
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }
    /* private int findWeight(int num) {
        int weight = 0;
        while (num > 0) {
            num &= (num - 1);
            weight++;
        }
        return weight;
    } */
}
