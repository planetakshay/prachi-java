package practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 
 * Implement a blocking queue.
 * 
 * @author Prachi
 * 
 *         LinkeIn phone screen.
 * 
 */
public class BlockingQueue {

	private Queue<String> queue = new LinkedList<String>();

	public static final int LIMIT = 10;

	public synchronized void enqueue(String str) {

		while (queue.size() == LIMIT) {

			try {

				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		queue.add(str);

		notifyAll();
	}

	public synchronized String dequeue() {

		// While is necessary since there might be multiple threads waiting for
		// new elements in the queue.
		// This is recommeneded in Java docs that when ever you are calling
		// wait() method it should be called
		// on the object whose lock is acquired by the current thread.

		// Java documentation also recommends to use wait() method inside any
		// kind of loop.
		while (queue.isEmpty()) {

			try {

				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		notifyAll();

		return queue.poll();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((queue == null) ? 0 : queue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlockingQueue other = (BlockingQueue) obj;
		if (queue == null) {
			if (other.queue != null)
				return false;
		} else if (!queue.equals(other.queue))
			return false;
		return true;
	}
}