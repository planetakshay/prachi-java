package practice2023.sorting;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {
    static int len;

    static ArrayList<Integer> radix_sort(ArrayList<Integer> arr) {
        len = arr.size();
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        int div = 1;
        while (true) {
            sortingHelper(arr, div);
            if ((max / div) / 10 == 0) {
                break;
            }
            div *= 10;
        }
        return arr;
    }

    static void sortingHelper(ArrayList<Integer> arr, int div) {
        List<List<Integer>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = 0; i < len; i++) {
            int curr = arr.get(i);
            int index = (curr / div) % 10;
            buckets.get(index).add(curr);
        }
        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < buckets.get(i).size(); j++) {
                arr.set(index++, buckets.get(i).get(j));
            }
        }
    }
}