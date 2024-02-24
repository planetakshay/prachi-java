package practice2023.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Apple Ads - Core functions onsite February 23, 2023.
 */
public class MedianInDataStream {
    // Holds smaller half of the data.
    // (i.e. highest among smaller elements at the top)
    // i.e. max heap.
    Queue<Long> min;
    // Holds larger half of the data.
    // (i.e. smallest among larger elements at the top)
    // i.e. min Heap.
    Queue<Long> max;
    public MedianInDataStream() {
        min = new PriorityQueue<>(Collections.reverseOrder());
        max = new PriorityQueue<>();
    }
    public Long addEvent(PlayEvent event) {
        Long median = 0l;
        Long duration = event.endedAt - event.startedAt;
        min.add(duration);
        balanceHeaps();
        median = findMedian();
        return median;
    }
    /**
     * Balance the heaps to ensure we have middle two
     * elements in the sorted data at the peek of both heaps.
     */
    private void balanceHeaps() {
        if((max.size() < min.size()) || (!max.isEmpty() && min.peek() > max.peek())) {
            max.add(min.poll());
        }
        if(max.size() > min.size()) {
            min.add(max.poll());
        }
    }
    private long findMedian() {
        int minSize = min.size();
        int maxSize = max.size();
        if(minSize == 0  && maxSize == 0) {
            return 0l;
        }
        if(minSize == maxSize) {
            return (long) (min.peek() + max.peek()) / 2;
        } else if (minSize > maxSize){
            return min.peek();
        } else {
            return max.peek();
        }
    }
    public static void main(String[] args) {
        MedianInDataStream medianFinder = new MedianInDataStream();
        PlayEvent event = new PlayEvent("1", 20l, 40l);
        assert medianFinder.addEvent(event) == 20l;
        PlayEvent event1 = new PlayEvent("2", 20l, 80l);
        assert medianFinder.addEvent(event) == 40l;
        PlayEvent event2 = new PlayEvent("3", 30l, 180l);
        assert medianFinder.addEvent(event) == 60l;
    }
}
class PlayEvent{
    String eventId;
    Long startedAt;
    Long endedAt;
    public PlayEvent(String eventId, Long startedAt, Long endedAt) {
        this.eventId = eventId;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
    }
}