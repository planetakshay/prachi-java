package practice2023.array;

public class WiggleSort {

    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if ((i % 2 == 0 && nums[i] > nums[i + 1]) || (i % 2 == 1 && nums[i] < nums[i + 1])) {
                swap(nums[i], nums[i + 1]);
            }
        }
    }

    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}