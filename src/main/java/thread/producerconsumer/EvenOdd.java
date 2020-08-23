package thread.producerconsumer;

/*Note:---
 * If a thread calls wait() method on an object, 
 * the thread IMMEDIATELY releases the lock of that object and goes into waiting state. 
 * But when a thread calls notify() method on an object,
 * the thread may not release the lock of that object immediately, 
 * as the thread may have some more job to do.
 * */

public class EvenOdd {
	public volatile int x = 0;

	public void printEven() throws InterruptedException {

		synchronized (this) {
			while ((x & 1) == 0) {
				System.out.println("--1");

				System.out.println(Thread.currentThread().getName() + " " + x);

				wait();

			}
			
			System.out.println("--2");
			Thread.sleep(1000);
			++x;
			System.out.println("--3");
			notify();
			System.out.println("--4");
		}
	}

	public void printOdd() throws InterruptedException {
		synchronized (this) {
			while ((x & 1) == 1) {
				System.out.println("--5");
				System.out.println(Thread.currentThread().getName() + " " + x);

				wait();

			}
			System.out.println("--6");
			Thread.sleep(1000);
			++x;
			System.out.println("--7");
			notify();
			System.out.println("--8");

		}
	}

	public static void main(String[] args) {

		final EvenOdd evenOdd = new EvenOdd();

		Thread t = new Thread(new Runnable() {

			public void run() {
				while (true) {
					try {
						evenOdd.printEven();
					} catch (InterruptedException e) {
					}
				}

			}
		}, "Even");

		t.start();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						evenOdd.printOdd();

					} catch (InterruptedException e) {
					}
				}

			}
		}, "Odd");

		t1.start();

	}
}
