package practice2023.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Interview Kickstart Exercise on all sorting algorithms.
 *
 * Glean interview asked insertion sort. -
 * Sort an almost sorted array where only one
 * element is out of order.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{35, 67, 23, 12, 5, 979, 343, 67, 87686, 45, 22, 78, 6, 4, 5};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));

        List<Integer> arr = Arrays.asList(5,6,7,2,1,7,42,34,3,2,6,5);
        mergeSort(arr);

        nums = new int[]{2, 3, 4,1};
        //insertionSort(nums);
        insertionSortPsuedoCode(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{4, 1, 2, 3};
        // insertionSort(nums);
        insertionSortPsuedoCode(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2, 3, 4, 6, 5, 7, 8};
        // insertionSort(nums);
        insertionSortPsuedoCode(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void selectionSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }

    public static void selectionSort(ArrayList<Integer> arr) {
        int len = arr.size();
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr.get(j) < arr.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = arr.get(minIndex);
            arr.set(minIndex, arr.get(i));
            arr.set(i, temp);
        }
    }

    static ArrayList<Integer> bubbleSort(ArrayList<Integer> arr) {
        // Write your code here.
        int len = arr.size();
        for(int i=0;i<len;i++) {
            for(int j=i+1;j <= len - 1;j++) {
                if(arr.get(i) > arr.get(j)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        return arr;
    }

    static void insertionSort(int[] arr) {
        int len = arr.length;
        for(int i=0;i<len;i++) {
            int temp = arr[i];
            int index = i-1;
            while(index >=0 && arr[index] > temp) {
                arr[index+1] = arr[index];
                index--;
            }
            arr[index+1] = temp;
        }
    }

    static void insertionSortPsuedoCode(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int j = i;
            while(j > 0 && nums[j-1] > nums[j]) {
                int temp = nums[j-1];
                nums[j-1] = nums[j];
                nums[j] = temp;
                j--;
            }
            i++;
        }
    }

    static ArrayList<Integer> insertion_sort(ArrayList<Integer> arr) {
        int len = arr.size();
        for(int i=0;i<len;i++) {
            int temp = arr.get(i);
            int index = i-1;
            while(index >=0 && arr.get(index) > temp) {
                arr.set(index+1, arr.get(index));
                index--;
            }
            arr.set(index+1,temp);
        }
        return arr;
    }

    static List<Integer> mergeSort(List<Integer> arr) {
        // Write your code here.
        mergeSort(arr, arr.size());
        return arr;
    }

    static void mergeSort(List<Integer> arr, int n) {
        if(n < 2) {
            return;
        }
        int mid = n / 2;
        List<Integer> left = new ArrayList<>(mid);
        List<Integer> right = new ArrayList<>(n-mid);
        for(int i=0;i<mid;i++) {
            left.add(arr.get(i));
        }
        for(int j=mid;j<n;j++) {
            right.add(arr.get(j));
        }
        mergeSort(left, mid);
        mergeSort(right,n-mid);
        merge(arr,left,right,mid, n-mid);
    }

    static void merge(List<Integer> arr, List<Integer> left, List<Integer> right, int start, int end) {
        int i = 0, j = 0, k = 0;

        while(i < start && j < end) {
            if(left.get(i) <= right.get(j)) {
                arr.set(k++, left.get(i++));
            } else {
                arr.set(k++, right.get(j++));
            }
        }
        while(i < start) {
            arr.set(k++, left.get(i++));
        }
        while(j < end) {
            arr.set(k++, right.get(j++));
        }
    }
}