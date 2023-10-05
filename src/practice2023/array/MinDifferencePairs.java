package practice2023.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinDifferencePairs {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 1, 3};
        MinDifferencePairs minDifferencePairs = new MinDifferencePairs();
        List<List<Integer>> ans = minDifferencePairs.minimumAbsDifference(arr);
    }

    /**
     * Uses counting sort for finding the element pairs.
     *
     * @param arr
     * @return
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList();
        if (arr == null || arr.length == 0) {
            return ans;
        }
        // populate counting array. Lines 15 - 27
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int len = arr.length;

        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int countingLen = max - min + 1;
        int[] frequency = new int[countingLen];
        for (int num : arr) {
            int index = num - min;
            frequency[index]++;
        }
        int start = 0;
        for(int i = 0; i < countingLen; i++) {
            if(frequency[i] > 0) {
                arr[start++] = min + i;
            }
        }

        for (int i = 0; i < len - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < min) {
                min = diff;
            }
        }
        for (int i = 0; i < len - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff == min) {
                ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[i + 1])));
            }
        }
        ans.stream().forEach(list -> {
            System.out.print(Arrays.toString(list.stream().mapToInt(Integer::intValue).toArray()));
        });
        return ans;
    }

    public List<List<Integer>> minimumAbsDifferenceSorting(int[] arr) {
        List<List<Integer>> ans = new ArrayList();
        if (arr == null || arr.length == 0) {
            return ans;
        }

        Arrays.sort(arr);
        int len = arr.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < len - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < min) {
                min = diff;
                // Old pairs with previously identified
                // min will no longer be the valid pair
                // hence clear the list.
                ans.clear();
            }
            if (diff == min) {
                ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[i + 1])));
            }
        }
        return ans;
    }
}
