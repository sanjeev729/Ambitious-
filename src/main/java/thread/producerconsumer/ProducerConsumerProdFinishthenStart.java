package thread.producerconsumer;

import java.util.LinkedList;
import java.util.List;

/**
 * Producer Class in java, Producer will allow consumer to consume only when 10
 * products have been produced (i.e. when production is over).
 */
class Producer2 implements Runnable {

	List<Integer> sharedQueue;

	Producer2() {
		sharedQueue = new LinkedList<Integer>();
	}

	@Override
	public void run() {

		synchronized (this) {
			for (int i = 1; i <= 10; i++) { // Producer will produce 10 products
				sharedQueue.add(i);
				System.out.println("Producer is still Producing, Produced : " + i);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			System.out.println("Production is over, consumer can consume.");
			// Production is over, notify consumer thread so that consumer can
			// consume.
			this.notify();
		}
	}

}

/**
 * Consumer Class.
 */
class Consumer2 extends Thread {
	Producer2 prod;

	Consumer2(Producer2 obj) {
		prod = obj;
	}

	public void run() {
		/*
		 * consumer will wait till producer is producing.
		 */
		synchronized (this.prod) {

			System.out.println("Consumer waiting for production to get over.");
			try {
				this.prod.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		/* production is over, consumer will start consuming. */
		int productSize = this.prod.sharedQueue.size();
		for (int i = 0; i < productSize; i++)
			System.out.println("CONSUMED : " + this.prod.sharedQueue.remove(0) + " ");

	}

}

public class ProducerConsumerProdFinishthenStart {
	public static void main(String args[]) throws InterruptedException {

		Producer2 prod = new Producer2();
		Consumer2 cons = new Consumer2(prod);

		Thread prodThread = new Thread(prod, "prodThread");
		Thread consThread = new Thread(cons, "consThread");

		consThread.start(); // start consumer thread.
		Thread.sleep(100); // This minor delay will ensure that consumer thread
							// starts before producer thread.
		prodThread.start(); // start producer thread.

	}

}