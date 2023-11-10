package practice2023.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTimeStamp {
    PriorityQueue<Event> queue;
    public PriorityQueueTimeStamp(PriorityQueue<Event> queue) {
        this.queue = new PriorityQueue<>(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return (int) (o1.timestamp - o2.timestamp);
            }
        });
    }
    public void add(Event event) {
        queue.add(event);
    }
    public Event poll() {
        return queue.poll();
    }
}

class Event {
    long timestamp;
    int eventId;
    String data;
    public Event(long timestamp, int eventId, String data) {
        this.timestamp = timestamp;
        this.eventId = eventId;
        this.data = data;
    }
}