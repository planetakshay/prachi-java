package practice2023.array;

public class NestedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{5,4,0,3,1,6,2};
        System.out.println("Total permutations: " + arrayNesting(nums));
    }
    public static int arrayNesting(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int total = 0;
        for(int i=0;i<len;i++) {
            if(nums[i] != Integer.MAX_VALUE) {
                int index = nums[i];
                int count = 0;
                while(nums[index] != Integer.MAX_VALUE) {
                    int temp = index;
                    index = nums[index];
                    count++;
                    nums[temp] = Integer.MAX_VALUE; // Mark element as visited.
                }
                total = Math.max(total,count);
            }
        }
        return total;
    }
}