package practice2023;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,5,6};
        System.out.println("Index: " + searchInsert(nums, 5));
        System.out.println("Index: " + searchInsert(nums, 2));
        System.out.println("Index: " + searchInsert(nums, 7));
        System.out.println("Index: " + searchInsert(nums, 4));
    }
    public static int searchInsert(int[] nums, int target) {
        for(int i = 0; i< nums.length; i++) {
            if(nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }
}
