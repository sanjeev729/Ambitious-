package thread.producerconsumer;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomQueue {
	private int maxSize;
	private List<Date> storage;
	private ReentrantLock lock;
	private Condition full;
	private Condition empty;

	public CustomQueue() {
		maxSize = 10;
		storage = new LinkedList<Date>();
		lock=new ReentrantLock();
		full=lock.newCondition();
		empty=lock.newCondition();
		
		
	}

	public void set() {
		lock.lock();
		while (storage.size() == maxSize) {
			try {
				full.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		storage.add(new Date());
		System.out.println("Set:" + storage.size());
		empty.signal();
		lock.unlock();
	}

	public void get() {
		lock.lock();
		while (storage.size() == 0) {
			try {
				empty.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Get" + storage.size() + ((LinkedList<Date>) storage).poll());
		full.signal();
		lock.unlock();
	}

	public static void main(String[] args) {

		CustomQueue queue = new CustomQueue();

		ProducerThread1 producer = new ProducerThread1(queue);
		Thread thread1 = new Thread(producer);

		ConsumerThread1 consumer = new ConsumerThread1(queue);
		Thread thread2 = new Thread(consumer);

		thread2.start();
		thread1.start();
	}
}

class ProducerThread1 implements Runnable {

	private CustomQueue queue;

	public ProducerThread1(CustomQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			queue.set();

		}
	}
}

class ConsumerThread1 implements Runnable {

	private CustomQueue queue;

	public ConsumerThread1(CustomQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			queue.get();

		}
	}
}
