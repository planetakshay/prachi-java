package practice2023.strings;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int weight = 0;
        while(n != 0) { // use != instead of > to cover for negative numbers
            n &= (n - 1);
            weight++;
        }
        return weight;
    }
}
