package thread.reenterent;

import java.util.concurrent.locks.ReentrantLock;

public class Synchronizeddemo2 {
	ReentrantLock l = new ReentrantLock(true);

	public void display(String name) {
		l.lock();

		for (int i = 0; i < 10; i++)
			System.out.println(name);

		l.unlock();

	}

	public static void main(String[] args) {
		Synchronizeddemo2 sd = new Synchronizeddemo2();
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				sd.display("Sanjeev");

			}
		});

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				sd.display("Kumar");

			}
		});

		t.start();
		t1.start();

	}

}
