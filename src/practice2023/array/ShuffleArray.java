package practice2023.array;

import java.util.Arrays;

public class ShuffleArray {

    public static void main(String[] args) {
        int[] nums = new int[] {2,5,1,3,4,7};
        int n = 3;
        System.out.println(Arrays.toString(shuffle(nums, 3)));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] shuffled = new int[2 * n];
        int j = 0;
        for(int i = 0; i < n; i++) {
            shuffled[j] = nums[i];
            shuffled[j+1] = nums[n+i];
            j += 2;
        }
        return shuffled;
    }
}
