package practice2023.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,2,3,1};
        System.out.println(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        int len = nums.length;
        for(int i=0;i<len;i++) {
            int num = nums[i];

            if(!left.containsKey(num)) {
                left.put(num, i);
            }
            right.put(num, i);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int degree = Collections.max(count.values());
        int shortest = len;
        for(int key : count.keySet()) {
            if(count.get(key) == degree) {
                shortest = Math.min(shortest, right.get(key) - left.get(key) + 1);
            }
        }
        return shortest;
    }
}