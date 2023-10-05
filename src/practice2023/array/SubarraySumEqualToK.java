package practice2023.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualToK {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        System.out.println("No of subarrays: " + subarraySum(nums, 2));
    }

    /**
     * Use hashmap. O(N) timecomplexity, O(n) space complexity.
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        // Count to keep track of no of different subarrays
        int count = 0, sum = 0;
        int len = nums.length;
        // Sum as key and no of occurrences of sum as value.
        Map<Integer, Integer> map = new HashMap< >();
        map.put(0, 1); // 0 sum occured once.
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    /**
     * O(N*N) time complexity, and O(1) space complexity
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySumInefficient(int[] nums, int k) {
        int count = 0;
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        for(int i=0;i<len;i++) {
            int sum = 0;
            for(int j=i; j< len; j++) {
                sum += nums[j];
                if(sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

}
