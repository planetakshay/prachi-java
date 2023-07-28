package practice2023;

import java.util.Arrays;

public class ConcatenateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        System.out.println(Arrays.toString(getConcatenation(nums)));
        System.out.println(Arrays.toString(concatenation(nums)));

        nums = new int[]{1,3, 2,1};
        System.out.println(Arrays.toString(getConcatenation(nums)));
        System.out.println(Arrays.toString(concatenation(nums)));
    }

    public static int[] getConcatenation(int[] nums) {
        int[] concatenate = new int[nums.length * 2];
        int j = 0;
        for(int i = 0; i < concatenate.length; i++) {
            concatenate[i] = nums[j++];
            if(j == nums.length) {
                j = 0;
            }
        }
        return concatenate;
    }
    public static int[] concatenation(int[] nums) {
        int[] concatenate = new int[nums.length * 2];
        System.arraycopy(nums, 0, concatenate, 0, nums.length);
        System.arraycopy(nums, 0, concatenate, nums.length, nums.length);
        return concatenate;
    }

}
