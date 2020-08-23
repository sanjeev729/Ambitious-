package thread.producerconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer1 extends Thread {
	BlockingQueue<Integer> q;

	public Producer1(BlockingQueue<Integer> q) {
		super();
		this.q = q;

	}

	public void run()

	{
		while (true) {

			Random r = new Random();
			int i = r.nextInt(100);
			System.out.println("start producing" + i);
			try {
				q.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}

class Consumer1 extends Thread {

	BlockingQueue<Integer> q;

	public Consumer1(BlockingQueue<Integer> q) {
		super();
		this.q = q;

	}

	public void run()

	{

		while (true) {
			try {
				Thread.sleep(1000);
				System.out.println("start consuming"+q.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}

public class ProducerConsumerBlockingQueue {

	public static void main(String[] args) {

		BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(4);

		Thread producer = new Producer1(q);
		Thread consumer = new Consumer1(q);

		producer.start();
		consumer.start();

	}

}
