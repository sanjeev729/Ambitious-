package thread.book;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorageProducerConsumer {
	private int maxSize;
	private List<Date> storage;

	public EventStorageProducerConsumer() {
		maxSize = 10;
		storage = new LinkedList<Date>();
	}

	public synchronized void set() {
		while (storage.size() == maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		storage.add(new Date());
		System.out.println("Set:" + storage.size());
		notifyAll();
	}

	public synchronized void get() {
		while (storage.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Get" + storage.size() + ((LinkedList<Date>) storage).poll());
		notifyAll();
	}

	public static void main(String[] args) {

		EventStorageProducerConsumer storage = new EventStorageProducerConsumer();

		ProducerThread producer = new ProducerThread(storage);
		Thread thread1 = new Thread(producer);

		ConsumerThread consumer = new ConsumerThread(storage);
		Thread thread2 = new Thread(consumer);

		thread2.start();
		thread1.start();
	}
}

class ProducerThread implements Runnable {

	private EventStorageProducerConsumer storage;

	public ProducerThread(EventStorageProducerConsumer storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			storage.set();

		}
	}
}

class ConsumerThread implements Runnable {

	private EventStorageProducerConsumer storage;

	public ConsumerThread(EventStorageProducerConsumer storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			storage.get();

		}
	}
}
