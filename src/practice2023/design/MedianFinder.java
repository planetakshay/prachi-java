package practice2023.design;

import javax.print.attribute.standard.Media;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> high;
    PriorityQueue<Integer> low;

    public MedianFinder() {
        high = new PriorityQueue<>();
        low = new PriorityQueue<>(Collections.reverseOrder());
    }

    /**
     * Priority queues have to be balanced each time a new number
     * is added.
     *
     * @param num
     */
    public void addNum(int num) {
        low.add(num);
        high.add(low.peek());
        low.poll();
        if (low.size() < high.size()) {
            low.add(high.peek());
            high.poll();
        }
    }

    public double findMedian() {
        double median = low.size() > high.size() ? low.peek() : ((double) low.peek() + high.peek()) * 0.5;
        return median;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median: " + medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println("Median: " + medianFinder.findMedian());
    }
}