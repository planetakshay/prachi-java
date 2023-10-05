package practice2023.array;

/**
 * https://leetcode.com/problems/patching-array/description/
 * https://leetcode.com/discuss/interview-question/424385/snowflake-phone-screen-patching-array
 *
 *
 */
public class PatchArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3};
        int n = 6;
        System.out.println("No of patches required: " + minPatches(nums, n));

        nums = new int[]{1,2,3,8};
        n = 16;
        System.out.println("No of patches required: " + minPatches(nums, n));

        nums = new int[]{1,5,10};
        n = 20;
        System.out.println("No of patches required: " + minPatches(nums, n));

        nums = new int[]{1,2,2};
        n = 5;
        System.out.println("No of patches required: " + minPatches(nums, n));

        nums = new int[]{6};
        n = 15;
        System.out.println("No of patches required: " + minPatches(nums, n));
    }

    public static int minPatches(int[] nums, int n) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        long miss = 1;
        int patch = 0;
        int index = 0;
        int len = nums.length;
        while(miss <= n) {
            if(index < len && nums[index] <= miss) {
                miss += nums[index++];
            } else {
                miss += miss;
                patch++;
            }
        }
        return patch;
    }
}
