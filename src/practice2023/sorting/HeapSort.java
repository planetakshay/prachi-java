package practice2023.sorting;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{45, 7, 20, 40, 25, 23, -2};
        arr = new int[]{5, 8, 3, 9, 4, 1, 7};
        System.out.println(Arrays.toString(arr));
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapify(int[] arr, int len, int index) {

        int largest = index; // root
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;

            heapify(arr, len, largest);
        }
    }

    public static void heapSort(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }
}