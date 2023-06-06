package practice2023;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(k+"th Largest Element = " + findKthLargestElement(nums,k));

        nums = new int[]{3,2,3,1,2,4,5,5,6};
        k = 4;
        System.out.println(k+"th Largest Element = " + findKthLargestElement(nums, k));
    }

    public static int findKthLargestElement(int[] nums, int k) {
        // Here priority queue kthLargestQueue will hold elements in
        // their natural sorted order up to k elements.
        // The following code will discard the larger elements than
        // Kth largest and at the end of the program the top most
        // element in the queue will be kth largest.
        Queue<Integer> kthLargestQueue = new PriorityQueue(k + 1);
        for (int i = 0; i < nums.length; i++) {
            kthLargestQueue.add(nums[i]);
            if (kthLargestQueue.size() > k) {
                kthLargestQueue.poll();
            }
        }
        return kthLargestQueue.poll();
    }
}