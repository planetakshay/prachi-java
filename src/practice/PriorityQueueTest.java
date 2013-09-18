package practice;

import java.util.PriorityQueue;

class Task implements Comparable<Task> {
	final int priority;
	final String name;

	public Task(int p, String n) {
		priority = p;
		name = n;
	}

	public String toString() {
		return priority + ", " + name;
	}

	public int compareTo(Task other) {

		if (priority < other.priority) {

			return -1;
		} else if (priority > other.priority) {

			return 1;
		}
		return 0;

	}
}

public class PriorityQueueTest {

	public static final void main(String[] args) {
		PriorityQueue<Task> pq = new PriorityQueue<Task>();
		pq.add(new Task(3, "Clear drains"));
		pq.add(new Task(4, "Feed cat"));
		pq.add(new Task(5, "Make tea"));
		pq.add(new Task(1, "Solve RC tasks"));
		pq.add(new Task(2, "Tax return"));

		while (!pq.isEmpty())
			System.out.println(pq.remove());
		
	}

}