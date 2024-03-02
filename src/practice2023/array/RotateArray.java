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
        try {
            System.out.println(rotateArray.get(1));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public int get(int index) throws Exception {
        if(index < 0 || index >= len) {
            throw new IndexOutOfBoundsException();
        }
        if (rotation != 0) {
            // index = len - rotation - index;
            index = (index + rotation - 1) % len;
            System.out.println("index : " + index + " rotation: " + rotation);
        }
        return array[index];
    }
    public void rotate(int rotation) {
        this.rotation += rotation;
    }
    // This is an update operation.
    public void put(int index, int value) throws Exception{
        if(index < 0 || index >= len) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }
}