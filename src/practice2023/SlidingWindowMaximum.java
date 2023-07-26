package practice2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // max queue

        for (int i = 0; i < nums.length; ++i) {
            while (!dq.isEmpty() && dq.peekLast() < nums[i]) dq.pollLast();
            dq.offerLast(nums[i]);
            if (i >= k && nums[i - k] == dq.peekFirst()) // out of bound
                dq.pollFirst();
            if (i >= k - 1) ans[i - k + 1] = dq.peekFirst();
        }

        return ans;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return null;
        }
        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.offer(i);
            if (i + 1 >= k) {
                ans[i + 1 - k] = nums[deque.peek()];
            }
        }
        return ans;
    }
}