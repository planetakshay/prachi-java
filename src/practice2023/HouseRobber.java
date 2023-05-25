package practice2023;

public class HouseRobber {
    public static int rob(int[] nums) {
        int i = 0; // include this house
        int e = 0; // money robbed excluding previous house

        for (int k = 0; k < nums.length; k++) {
            int tmp = i;
            i = nums[k] + e;
            e = Math.max(tmp, e);
        }
        return Math.max(i, e);
    }

    public static void main(String args[]) {
        int nums[] = new int[]{1000, 11000, 3000, 1000, 400, 2000, 500};
        System.out.println("Maximum money that can be robbed = " + rob(nums));
    }
}

