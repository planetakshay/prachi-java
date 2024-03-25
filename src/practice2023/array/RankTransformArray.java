package practice2023.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/rank-transform-of-an-array/
 */
public class RankTransformArray {
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int len = arr.length;
        int[] sorted = Arrays.copyOf(arr, len);
        Arrays.sort(sorted);
        int[] ranks = new int[len];
        int rank = 1;
        Map<Integer, Integer> numToRank = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!numToRank.containsKey(sorted[i])) {
                numToRank.put(sorted[i], rank++);
            }
        }
        for (int i = 0; i < len; i++) {
            ranks[i] = numToRank.get(arr[i]);
        }
        return ranks;
    }
}