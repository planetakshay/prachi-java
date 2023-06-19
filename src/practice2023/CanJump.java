package practice2023;

public class CanJump {

    public static boolean canJump(int[] nums) {
        int indexToReach = nums.length - 1;
        for(int i = indexToReach; i>=0; i--) {
            if(i + nums[i] >= indexToReach) {
                indexToReach = i;
            }
        }
        return indexToReach == 0;
    }

    public static void main(String args[]) {
        int[] nums = new int[] {2,3,1,1,4};
        System.out.println("Can the last element be reached: " + canJump(nums));

        nums = new int[] {3,2,1,0,4};
        System.out.println("Can the last element be reached: " + canJump(nums));
    }
}
