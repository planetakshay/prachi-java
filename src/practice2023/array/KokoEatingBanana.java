package practice2023.array;

/**
 * https://leetcode.com/problems/koko-eating-bananas/editorial/
 *
 * to find minimum speed we will use binary search.
 *
 */
public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for(int pile : piles) {
            right = Math.max(right, pile);
        }
        while(left < right) {
            int mid = (right-left)/2 + left;
            int elapsed = 0;
            for(int i = 0;i < piles.length; i++) {
                elapsed += Math.ceil((double) piles[i] / mid);
            }
            if(elapsed <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
