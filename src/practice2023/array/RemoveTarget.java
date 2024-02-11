package practice2023.array;

public class RemoveTarget {

    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 2, 3};
        System.out.println("test: " + removeElement(nums, 3));
    }
    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int count = 0;

        while(start < end) {
            if(nums[start] == val) {
                while (end > start && nums[end] == nums[start]) {
                    end--;
                }
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                // end--;
                count++;
            }
            start++;
        }
        return count;
    }
}
