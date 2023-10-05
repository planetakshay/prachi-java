package practice2023.array;

public class PeakElement {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println("Peak Element at: " + findPeakElementBruteForce(nums));
        System.out.println("Peak Element at: " + findPeakElement(nums));
        System.out.println("Peak Element at: " + findPeakElementRecursive(nums));
    }

    /**
     * Binary Search Iterative solution.
     * O(logN) time complexity. O(1) space complexity
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = (right + left) / 2;
            if(nums[mid] > nums[mid+1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * find peak element using binary search recursive algorithm
     * O(logN) time complexity. O(1) space complexity
     *
     * @param nums
     * @return
     */
    public static int findPeakElementRecursive(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public static int search(int[] nums, int left, int right) {
        if(left == right) {
            return left;
        }
        int mid = (left + right) / 2;
        if(nums[mid] > nums[mid + 1]) {
            return search(nums, left, mid);
        } else {
            return search(nums, mid + 1, right);
        }
    }

    /**
     * O(N) runtime. O(1) space (no additional space used)
     * @param nums
     * @return
     */
    public static int findPeakElementBruteForce(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }
}
