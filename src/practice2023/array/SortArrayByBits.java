package practice2023.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/
 */
public class SortArrayByBits {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8};

        System.out.println("Sort by no of 1 bits: " + Arrays.toString(sortByBits(arr)));
        System.out.println("Sort by no of 1 bits: " + Arrays.toString(sortByBitsBrianKerninghan(arr)));
    }
    public static int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (Integer.bitCount(a) == Integer.bitCount(b)) {
                    return a - b;
                }
                return Integer.bitCount(a) - Integer.bitCount(b);
            }
        });
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }

    public static int[] sortByBitsBrianKerninghan(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, new Comparator<Integer>() {
            public int findWeight(Integer num) {
                int weight = 0;
                while (num > 0) {
                    num &= (num - 1);
                    weight++;
                }
                return weight;
            }

            @Override
            public int compare(Integer a, Integer b) {
                if (findWeight(a) == findWeight(b)) {
                    return a - b;
                }
                return findWeight(a) - findWeight(b);
            }
        });
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}