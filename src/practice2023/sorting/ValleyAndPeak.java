package practice2023.sorting;

import java.util.Arrays;

/**
 * Valley and Peak algorithm from Cracking coding interview
 * 6th edition book in searching and sorting.
 *
 *
 */
public class ValleyAndPeak {
    public static void main(String[] args) {
        int[] array = new int[] {5, 8, 6, 2, 3, 4, 6};
        valleyAndPeak(array);
        System.out.println("Valley and Peak: " + Arrays.toString(array));

        array = new int[] {5, 3, 1, 2, 3};
        valleyAndPeak(array);
        System.out.println("Valley and Peak: " + Arrays.toString(array));
    }

    public static void valleyAndPeak(int[] array) {
        if(array == null || array.length <= 2) {
            return;
        }
        int len = array.length;
        for(int i = 1; i < len; i += 2) {
            int index = getHighestIndex(array, len, i);
            if(i != index) {
                swap(array, i , index);
            }
        }
    }
    // Returns highest index for swapping,
    public static int getHighestIndex(int[] array,int len, int index) {
        int ltValue = (index-1) >= 0 && (index-1) < len ? array[index-1] : Integer.MIN_VALUE;
        int midValue = (index) >= 0 && (index) < len ? array[index] : Integer.MIN_VALUE;
        int rtValue = (index+1) >= 0 && (index+1) < len ? array[index+1] : Integer.MIN_VALUE;

        int max = Math.max(ltValue, Math.max(midValue, rtValue));
        if(ltValue == max) {
            return index - 1;
        } else if(midValue == max) {
            return index;
        } else {
            return index + 1;
        }
    }
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}