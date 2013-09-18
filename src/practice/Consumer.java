package practice;

import java.util.Random;

class Producer extends Thread {

	public static final int MAX_CAPACITY = 8;

	public static final int RANDOM_RANGE = 128;

	private int[] buffer;

	private int index;

	private Random generator;

	public Producer() {

		buffer = new int[8];

		generator = new Random(23);

		index = 0;
	}

	public void run() {

		while (true) {

			try {

				putInt();
			} catch (InterruptedException e) {

			}
		}
	}

	private synchronized void putInt() throws InterruptedException {

		while (index == MAX_CAPACITY) {

			wait();
		}
		buffer[index] = generator.nextInt(RANDOM_RANGE);

		index++;

		notifyAll();
	}

	public synchronized int getInt() throws InterruptedException {

		notifyAll();

		while (index <= 0) {

			wait();
		}

		index--;

		return buffer[index];
	}
}

public class Consumer extends Thread {

	Producer producer;

	public Consumer(Producer producer) {

		this.producer = producer;
	}

	public void run() {

		try {
			while (true) {

				System.out.println("Int: " + producer.getInt());
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void main(String args[]) {

		Producer producer = new Producer();

		producer.start();

		Consumer consumer = new Consumer(producer);

		consumer.start();
	}
}