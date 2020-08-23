package thread.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Producer extends Thread {
	Queue<Integer> q;
	int maxsize;

	public Producer(Queue<Integer> q, int maxsize) {
		super();
		this.q = q;
		this.maxsize = maxsize;
	}

	public void run()

	{
		while (true) {
			synchronized (q) {

				while (q.size() == maxsize) {
					try {
						q.wait();
						//break;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Random r = new Random();
				int i = r.nextInt(100);
				System.out.println("start producing" + i);
				q.add(i);
				q.notify();
			}

		}
	}
}

class Consumer extends Thread {

	Queue<Integer> q;
	int maxsize;

	public Consumer(Queue<Integer> q, int maxsize) {
		super();
		this.q = q;
		this.maxsize = maxsize;
	}

	public void run()

	{

		while (true) {

			synchronized (q) {
				
				while (q.isEmpty()) {
					try {
						q.wait();
						//break;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("consuming!!" + q.remove());
				q.notify();
			}

		}
	}

}

public class ProducerConsumer {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		int max = 50;

		Thread producer = new Producer(q, max);
		Thread consumer = new Consumer(q, max);

		producer.start();
		consumer.start();

	}

}
