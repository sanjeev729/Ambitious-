package thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

class BTCabService1 implements Runnable {

	CountDownLatch cl;

	public BTCabService1(CountDownLatch cl) {
		this.cl = cl;

	}

	@Override
	public void run() {
		System.out.println("Befor " + Thread.currentThread().getName() + " " + cl.getCount());
		cl.countDown();
		System.out.println("After" + Thread.currentThread().getName() + " " + cl.getCount());

	}

}

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cl = new CountDownLatch(3);
		Thread t1 = new Thread(new BTCabService1(cl));
		Thread t2 = new Thread(new BTCabService1(cl));
		Thread t3 = new Thread(new BTCabService1(cl));

		t1.start();
		Thread.sleep(2000);
		t2.start();
		Thread.sleep(2000);

		t3.start();
		Thread.sleep(2000);

		cl.await();
		System.out.println("Main Finishes");

		/*
		 * t7.start(); t8.start(); t9.start(); t10.start();
		 */

	}

}
