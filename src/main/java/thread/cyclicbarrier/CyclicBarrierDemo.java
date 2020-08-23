

/*The CyclicBarrier class is initialized with an integer number, which is the number of threads
that will be synchronized in a determined point. When one of those threads arrives to the
determined point, it calls the await() method to wait for the other threads. When the thread
calls that method, the CyclicBarrier class blocks the thread that is sleeping until the other
threads arrive. When the last thread calls the await() method of the CyclicBarrier class,
it wakes up all the threads that were waiting and continues with its job.*/


package thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class BTCabService implements Runnable {

	CyclicBarrier cb;

	public BTCabService(CyclicBarrier cb) {
		this.cb = cb;

	}

	@Override
	public void run() {
		System.out.println("Hello " + Thread.currentThread().getName());

		try {

			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("World");

	}

}

public class CyclicBarrierDemo {

	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier cb = new CyclicBarrier(3);
		Thread t1 = new Thread(new BTCabService(cb));
		Thread t2 = new Thread(new BTCabService(cb));
		Thread t3 = new Thread(new BTCabService(cb));
		Thread t4 = new Thread(new BTCabService(cb));
		Thread t5 = new Thread(new BTCabService(cb));
		Thread t6 = new Thread(new BTCabService(cb));
		Thread t7 = new Thread(new BTCabService(cb));
		Thread t8 = new Thread(new BTCabService(cb));
		Thread t9 = new Thread(new BTCabService(cb));
		Thread t10 = new Thread(new BTCabService(cb));
		t1.start();
		Thread.sleep(2000);
		t2.start();
		Thread.sleep(2000);

		t3.start();
		Thread.sleep(2000);
		t4.start();
		Thread.sleep(2000);
		t5.start();
		Thread.sleep(2000);
		t6.start();

		/*
		 * t7.start(); t8.start(); t9.start(); t10.start();
		 */

	}

}
