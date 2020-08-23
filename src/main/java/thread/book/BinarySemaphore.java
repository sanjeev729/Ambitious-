
/*
 * Controlling concurrent access to a resource recipe, you learned the basis
of semaphores.
*/

package thread.book;

import java.util.concurrent.Semaphore;

public class BinarySemaphore {
	private final Semaphore semaphore;
	private final Semaphore semaphore1;

	public BinarySemaphore() {
		semaphore = new Semaphore(5);
		semaphore1 = new Semaphore(1, true);
	}

	public void printJob(Object document) {
		try {
			semaphore.acquire();
			long duration = (long) (Math.random() * 10);
			System.out.println(
					"Acquired lock Printing Read Job " + Thread.currentThread().getName() + " Duration " + duration);
			Thread.sleep(duration);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}

	}

	public void printJob1(Object document) {
		try {
			semaphore1.acquire();
			long duration = (long) (Math.random() * 10);
			System.out.println(
					"Acquired lock Printing write Job " + Thread.currentThread().getName() + " Duration " + duration);
			Thread.sleep(duration);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore1.release();
		}

	}

	public static void main(String args[]) {

		BinarySemaphore printQueue = new BinarySemaphore();

		Thread thread[] = new Thread[10];
		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(new Job(printQueue), "Thread" + i);

		}

		for (int i = 0; i < 10; i++) {
			thread[i].start();
		}
	}
}

class Job implements Runnable {
	private BinarySemaphore printQueue;

	public Job(BinarySemaphore printQueue) {
		this.printQueue = printQueue;
	}

	@Override
	public void run() {

		System.out.println("going to print job " + Thread.currentThread().getName());
		printQueue.printJob(new Object());
		printQueue.printJob1(new Object());
		System.out.println("job has been printed " + Thread.currentThread().getName());

	}
}