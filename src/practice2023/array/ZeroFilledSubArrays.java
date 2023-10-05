package practice2023.array;

public class ZeroFilledSubArrays {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,0,0,2,0,0,4};
        System.out.println("Zero filled subArrays: " + zeroFilledSubarray(nums));

        nums = new int[]{0,0,0,2,0,0};
        System.out.println("Zero filled subArrays: " + zeroFilledSubarray(nums));

        nums = new int[]{2,10,2019};
        System.out.println("Zero filled subArrays: " + zeroFilledSubarray(nums));
    }

    public static long zeroFilledSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int totalSubArrays = 0, subArray = 0;
        for (int num : nums) {
            if (num == 0) {
                subArray++;
            } else {
                subArray = 0;
            }
            totalSubArrays += subArray;
        }
        return totalSubArrays;
    }
}
