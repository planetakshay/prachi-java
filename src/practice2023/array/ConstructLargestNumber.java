package practice2023.array;

import java.util.Arrays;
import java.util.Comparator;

public class ConstructLargestNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 2};
        System.out.println("Largest number possible from nums: " + largestNumber(nums));
        nums = new int[]{3, 30, 34, 5, 9};
        System.out.println("Largest number possible from nums: " + largestNumber(nums));
        nums = new int[]{0,0};
        System.out.println("Largest number possible from nums: " + largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        StringBuilder largest = new StringBuilder();
        if (nums == null || nums.length == 0) {
            return largest.toString();
        }
        int len = nums.length;
        // Convert all numbers into Strings.
        String[] numsAsString = new String[len];
        for (int i = 0; i < len; i++) {
            numsAsString[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsAsString, new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                return (second + first).compareTo(first + second);
            }
        });
        for (String num : numsAsString) {
            largest.append(num);
        }
        // After sorting, the arrays first element will be the most significant
        // number(because of which the largest number can be formed.
        // With that said if the array consists only zeros then only the first
        // element in the sorted array will be zero and in that case
        // we just return a '0' to avoid getting '00' as output.
        return largest.charAt(0) == '0' ? "0" : largest.toString();
    }
}
