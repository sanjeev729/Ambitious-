
/*
 * Controlling concurrent access to multiple copies of a resource
 * 
 * In that recipe, you implemented an example using binary semaphores. These kinds of
semaphores are used to protect the access to one shared resource, or to a critical section
that can only be executed by one thread at a time. But semaphores can also be used when
you need to protect various copies of a resource, or when you have a critical section that can
be executed by more than one thread at the same time
 * 
 * 
 * In this recipe, you will learn how to use a semaphore to protect more than one copy of a
resource. You are going to implement an example, which has one print queue that can print
documents in three different printers.
*/

package thread.book;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintJobs {
	private final Semaphore semaphore;
	private boolean freePrinters[];
	private Lock lockPrinters;

	public PrintJobs() {
		semaphore = new Semaphore(3);
		freePrinters = new boolean[3];

		for (int i = 0; i < 3; i++)
			freePrinters[i] = true;

		lockPrinters = new ReentrantLock();

	}

	public void printJob(Object document) {
		try {
			semaphore.acquire();
			int assignedPrinter = getPrinter();

			long duration = (long) (Math.random() * 10);
			System.out.println(
					"Acquired lock Printing Read Job " + Thread.currentThread().getName() + " Duration " + duration);
			Thread.sleep(duration);
			freePrinters[assignedPrinter] = true;

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}

	}

	private int getPrinter() {
		int ret = -1;
		try {
			lockPrinters.lock();

			for (int i = 0; i < freePrinters.length; i++) {
				if (freePrinters[i]) {
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
		} finally {
			lockPrinters.unlock();
		}
		return ret;
	}

	public static void main(String args[]) {

		PrintJobs printQueue = new PrintJobs();

		Thread thread[] = new Thread[10];
		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(new Job2(printQueue), "Thread" + i);

		}

		for (int i = 0; i < 10; i++) {
			thread[i].start();
		}
	}
}

class Job2 implements Runnable {
	private PrintJobs printQueue;

	public Job2(PrintJobs printQueue) {
		this.printQueue = printQueue;
	}

	@Override
	public void run() {

		System.out.println("going to print job " + Thread.currentThread().getName());
		printQueue.printJob(new Object());

		System.out.println("job has been printed " + Thread.currentThread().getName());

	}
}