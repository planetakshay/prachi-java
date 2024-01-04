package practice2023.design;

import java.util.Random;

/**
 * https://leetcode.com/problems/shuffle-an-array/
 */
public class ShuffleArray {
    int len;
    Random random = new Random();
    private int[] array;
    private int[] original;

    public ShuffleArray(int[] nums) {
        array = nums;
        original = nums.clone();
        len = array.length;
    }

    private int generateRandom(int start, int end) {
        return random.nextInt(end - start) + start;
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < this.len; i++) {
            int j = generateRandom(i, this.len);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
}