package practice2023.array;

import java.util.List;

/**
 * https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/
 */
public class SumAtIndicesKBitsSet {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int size = nums.size();
        int sum = 0;
        for(int i=0;i<size; i++) {
            if(hammingWeight(i) == k) {
                sum += nums.get(i);
            }
        }
        return sum;
    }

    private int hammingWeight(int n) {
        int weight = 0;
        while(n != 0) { // use != instead of > to cover for negative numbers
            n &= (n - 1);
            weight++;
        }
        return weight;
    }
}
