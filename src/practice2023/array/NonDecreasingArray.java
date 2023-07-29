package practice2023.array;

public class NonDecreasingArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,3};
        System.out.println("Can be non-descreasing: " + checkPossibility(nums));

        nums = new int[]{4,2,1};
        System.out.println("Can be non-descreasing: " + checkPossibility(nums));

        nums = new int[]{3,4,2,3};
        System.out.println("Can be non-descreasing: " + checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int violations = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] > nums[i]) {
                if(violations == 1) {
                    return false;
                }
                violations++;
                if(i < 2 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i -1];
                }
            }
        }
        return true;
    }
}