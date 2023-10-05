package practice2023.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimizeMaximumPairSum {
    public int minPairSum(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> Integer.compare(b,a));
        PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> Integer.compare(a,b));

        for(int num : nums) {
            max.add(num);
            min.add(num);
        }
        int end = len / 2;
        int sum = 0;
        int maxSoFar = Integer.MIN_VALUE;
        while(end >0) {
            int a = max.poll();
            int b = min.poll();
            maxSoFar = Math.max((max.poll() + min.poll()), maxSoFar);
            end--;
        }
        return maxSoFar;
    }
}
