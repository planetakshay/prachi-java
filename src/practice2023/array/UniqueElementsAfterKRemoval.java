package practice2023.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class UniqueElementsAfterKRemoval {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 5, 4};
        int k = 1;
        System.out.println("Least uniques after " + k + " removals: " + findLeastNumOfUniqueInts(nums
                , k));
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(freq.values());
        while(k > 0) {
            k -= pq.poll();
        }
        int size = pq.size();
        return k >= 0 ? size : size + 1;
    }
}