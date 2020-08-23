package thread.reenterent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {

	private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
	private static String message = "a";

	public static void main(String[] args) throws InterruptedException {
		Thread tr4 = new Thread(new Read());
		Thread tr3 = new Thread(new Read());
		Thread tr2 = new Thread(new Read());
		Thread tr1 = new Thread(new Read());
		Thread t2 = new Thread(new WriteA());
		Thread t3 = new Thread(new WriteB());
		tr1.start();
		tr2.start();
		tr3.start();
		tr4.start();
		t2.start();
		t3.start();

		t2.join();
		t3.join();
	}

	static class Read implements Runnable {

		public void run() {
			for (int i = 0; i < 5; i++) {
				lock.readLock().lock();
				System.out.println("ReadThread1 " + Thread.currentThread().getName() + " ---> Message is " + message);
				lock.readLock().unlock();
			}
		}
	}

	static class WriteA implements Runnable {

		public void run() {
			for (int i = 0; i <= 10; i++) {
				try {
					lock.writeLock().lock();
					// message = message.concat("a");
					System.out.println("WriteA " + Thread.currentThread().getName());
				} finally {
					lock.writeLock().unlock();
				}
			}
		}
	}

	static class WriteB implements Runnable {

		public void run() {
			for (int i = 0; i <= 10; i++) {
				try {
					lock.writeLock().lock();
					// message = message.concat("b");
					System.out.println("WriteB " + Thread.currentThread().getName());
				} finally {
					lock.writeLock().unlock();
				}
			}
		}
	}
}
