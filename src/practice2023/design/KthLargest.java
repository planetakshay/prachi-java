package practice2023.design;

import java.util.PriorityQueue;

public class KthLargest {
    private int k;
    private PriorityQueue minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for(int num : nums) {
            minHeap.add(num);
        }
        while(minHeap.size() > k) {
            minHeap.poll();
        }
    }
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size() > k) {
            minHeap.poll();
        }
        return (int) minHeap.peek();
    }
}