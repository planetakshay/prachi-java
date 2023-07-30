package practice2023.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println("Product array: " + Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        int[] answer = new int[len];
        answer[0] = 1;
        for (int i = 1; i < len; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        int rProd = 1;
        for (int j = len - 1; j >= 0; j--) {
            answer[j] = answer[j] * rProd;
            rProd *= nums[j];
        }
        return answer;
    }
}