package practice2023.array;

public class KthMissingNumber {
    public static void main(String[] args) {
        int k = 1;
        int[] nums = new int[]{4, 7, 9, 10};
        System.out.println(k + getSuffix(k) + " missing number: " + missingElement(nums, k));

        k = 3;
        nums = new int[]{4, 7, 9, 10};
        System.out.println(k + getSuffix(k) + " missing number: " + missingElement(nums, k));

        k = 3;
        nums = new int[]{1, 2, 4};
        System.out.println(k + getSuffix(k) + " missing number: " + missingElement(nums, k));
    }

    public static int missingElement(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        for (int i = 1; i < len; i++) { // 1, 10 k = 5
            int missing = nums[i] - nums[i-1] - 1;
            if(missing >= k) {
                return nums[i-1] + k;
            }
            k -= missing;
        }
        return nums[len - 1] + k;
    }

    private static String getSuffix(int k) {
        String suffix = "th";
        if (k == 1) {
            suffix = "st";
        } else if (k == 2) {
            suffix = "nd";
        } else if (k == 3) {
            suffix = "rd";
        }
        return suffix;
    }
}
