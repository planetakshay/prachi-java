package practice2023.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/next-greater-element-i/description/
 *
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
        System.out.println(Arrays.toString(bruteForce(nums1, nums2)));

        nums1 = new int[]{1,3,5,2,4};
        nums2 = new int[]{6,5,4,3,2,1,7};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
        System.out.println(Arrays.toString(bruteForce(nums1, nums2)));
    }
    public static int[] bruteForce(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = -1;
        }
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    // find greater
                    for(int k = j + 1; k < nums2.length; k++) {
                        if(nums2[k] > nums1[i]) {
                            ans[i] = nums2[k];
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }

    /**
     * A better brute force using map.
     *
     * @param nums1
     * @param nums2
     * @return
     */

    // Create a map of nums2 element and its index.
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Map<Integer, Integer> eleLocation = new HashMap<>();
        for(int i = 0; i < len2; i++) {
            eleLocation.put(nums2[i], i);
        }
        // Loop over all nums1 elements and find the next greater
        // in nums2 from the next index of its occurence in nums2.
        int[] ans = new int[len1];
        int j;
        for(int i = 0; i < len1; i++) {
            int begin = eleLocation.get(nums1[i]) + 1; // next index from its location
            for(j = begin; j < len2; j++) {
                if(nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                    break; // very important.
                }
            }
            if(j == len2) { // next greater element isn't found.
                ans[i] = -1;
            }
        }
        return ans;
    }
}