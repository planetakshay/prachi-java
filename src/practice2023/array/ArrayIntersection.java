package practice2023.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/intersection-of-three-sorted-arrays/description/
 */
public class ArrayIntersection {
    private int[] ans;
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{1, 2, 5, 7, 9};
        int[] arr3 = new int[]{1, 3, 4, 5, 8};

        ArrayIntersection arrayIntersection = new ArrayIntersection();
        System.out.println("Intersection: " + Arrays.toString(arrayIntersection.arraysInterEfficient(arr1, arr2, arr3).toArray()));
    }

    private void setFreq(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int index = arr[i] - 1;
            ans[index]++;
        }
    }

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : arr1) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        for (int i : arr2) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        for (int i : arr3) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        freq = freq.entrySet().stream().filter(entry -> entry.getValue() == 3).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Set<Integer> intersectionSet = new TreeSet<>(freq.keySet().stream().collect(Collectors.toSet()));
        return intersectionSet.stream().collect(Collectors.toList());
    }

    /**
     * Since the problem constraints state that the elements range in the
     * arrays will be 1 - 2000 we can use answer array of size 2000 and
     * increment frequency of each number.
     * <p>
     * and then collect the elements with exactly 3 occurances since the
     * input arrays are strictly increasing.
     *
     * @param arr1
     * @param arr2
     * @param arr3
     * @return
     */
    public List<Integer> arraysInterEfficient(int[] arr1, int[] arr2, int[] arr3) {
        ans = new int[2000];
        setFreq(arr1);
        setFreq(arr2);
        setFreq(arr3);

        List<Integer> intersection = new LinkedList<>();
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 3) {
                intersection.add(i + 1);
            }
        }
        return intersection;
    }
}