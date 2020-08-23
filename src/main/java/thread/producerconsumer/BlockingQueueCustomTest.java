package thread.producerconsumer;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementing custom BlockingQueue interface . This BlockingQueue
 * implementation follows FIFO (first-in-first-out). New elements are inserted
 * at the tail of the queue, and removal elements is done at the head of the
 * queue.
 */
interface BlockingQueueCustom<E> {

	/**
	 * Inserts the specified element into this queue only if space is available
	 * else waits for space to become available.
	 */
	void put(E item) throws InterruptedException;

	/**
	 * Retrieves and removes the head of this queue only if elements are
	 * available else waits for element to become available.
	 */
	E take() throws InterruptedException;
}

/**
 * Implementing custom LinkedBlockingQueue class. This BlockingQueue
 * implementation follows FIFO (first-in-first-out). New elements are inserted
 * at the tail of the queue, and removal elements is done at the head of the
 * queue.
 *
 */
class LinkedBlockingQueueCustom<E> implements BlockingQueueCustom<E> {

	private List<E> queue;
	private int maxSize; // maximum number of elements queue can hold at a time.

	public LinkedBlockingQueueCustom(int maxSize) {
		this.maxSize = maxSize;
		queue = new LinkedList<E>();
	}

	/**
	 * Inserts the specified element into this queue only if space is available
	 * else waits for space to become available. After inserting element it
	 * notifies all waiting threads.
	 */
	public synchronized void put(E item) throws InterruptedException {

		// check space is available or not.
		if (queue.size() == maxSize) {
			this.wait();
		}

		// space is available, insert element and notify all waiting threads.
		queue.add(item);
		this.notifyAll();
	}

	/**
	 * Retrieves and removes the head of this queue only if elements are
	 * available else waits for element to become available. After removing
	 * element it notifies all waiting threads.
	 */
	public synchronized E take() throws InterruptedException {

		// waits element is available or not.
		if (queue.size() == 0) {
			this.wait();
		}

		// element is available, remove element and notify all waiting threads.
		E element = queue.remove(0);
		this.notifyAll();
		return element;

	}

}

public class BlockingQueueCustomTest {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueueCustom<Integer> b = new LinkedBlockingQueueCustom<Integer>(10);
		System.out.println("put(11)");
		b.put(11);
		System.out.println("put(12)");
		b.put(12);
		System.out.println("take() > " + b.take());
		System.out.println("take() > " + b.take());

	}
}