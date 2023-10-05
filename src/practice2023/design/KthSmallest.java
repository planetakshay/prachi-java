package practice2023.design;

import java.util.PriorityQueue;

public class KthSmallest {
    private int k;
    private PriorityQueue<Integer> queue;

    public KthSmallest(int k, int[] nums) {
        this.k = k ;
        queue = new PriorityQueue<>();
        for(int num : nums) {
            queue.add(num);
        }
        while(queue.size() > k) {
            queue.poll();
        }
    }
    public int add(int val) {
        queue.offer(val);
        if(queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
