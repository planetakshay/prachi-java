package practice2023.array;

import java.util.Arrays;

/**
 *
 * Zscaler phone screen.
 *
 * Implement a class called CircularArray.
 * Class constructor should accept an array. Class should implement next methods
 *
 * void rotate(int n)
 * int get(int index)
 * void put(int index, int val)
 *
 * [4,5,6] -> [6, 5, 4] -> [5, 6 ,4]
 * get(0) -> 4
 * rotate(1) void [5,6,4]
 * get(0) -> 5
 * put(0,7) [7,6,4]
 *
 *
 * ex2
 * [4, 5 ,6]
 * rotation(2) - [6,4,5]
 * get(1)
 */
public class RotateArray {
    int[] array;
    int rotation;
    int len = 0;

    public RotateArray(int[] input) {
        this.array = input;
        this.len = array.length;
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray(new int[]{4, 5, 6, 9, 10});
        rotateArray.rotate(1);
        rotateArray.rotate(1);
        System.out.println(Arrays.toString(rotateArray.array));
        System.out.println(rotateArray.get(1));
    }
    public int get(int index) {
        if (rotation != 0) {
            index = len - rotation - index;
        }
        return array[index];
    }
    public void rotate(int rotation) {
        this.rotation += rotation;
    }
    public void put(int index, int value) {
        array[index] = value;
    }
}