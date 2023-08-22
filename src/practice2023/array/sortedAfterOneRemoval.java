package practice2023.array;

public class sortedAfterOneRemoval {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 10, 5, 7};
        System.out.println("canBeIncreasing: " + canBeIncreasing(nums));

        nums = new int[]{2,3,1,2};
        System.out.println("canBeIncreasing: " + canBeIncreasing(nums));

        nums = new int[]{1,1,1};
        System.out.println("canBeIncreasing: " + canBeIncreasing(nums));

        nums = new int[]{1,2,3};
        System.out.println("canBeIncreasing: " + canBeIncreasing(nums));

        nums = new int[]{100,21,3};
        System.out.println("canBeIncreasing: " + canBeIncreasing(nums));

        nums = new int[]{100,21,100};
        System.out.println("canBeIncreasing: " + canBeIncreasing(nums));
    }

    public static boolean canBeIncreasing(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        boolean removed = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                if (removed) {
                    return false;
                }
                removed = true;
                if (i > 1 && nums[i-2] >= nums[i]) {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }

    public static boolean canBeIncreasingIn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int count = 0;
        int index = -1;
        int len = nums.length;
        for (int i = 1; i < len - 1; i++) {
            if (nums[i - 1] >= nums[i]) {
                index = i;
            }
            if (nums[i-1] > nums[i+1]) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        if (nums[len - 2] > nums[len - 1] && index != -1) {
            count++;
        }
        if (index == -1) {
            return true;
        }
        if(index != -1 && count == 0) {
            return true;
        }
        return count == 1;
    }
}
