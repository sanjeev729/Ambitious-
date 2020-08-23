package thread.reenterent;

import java.util.concurrent.locks.ReentrantLock;

public class Trylockdemo extends Thread {
	public static ReentrantLock l = new ReentrantLock(true);

	public Trylockdemo(String tname) {
		super(tname);
	}

	public void run() {
		if (l.tryLock()) {
			System.out.println(Thread.currentThread().getName() + "Got the lock Inside");
			try {
				Thread.sleep(20000);

				l.unlock();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			System.out.println(Thread.currentThread().getName() + "Try next time");

	}

	public static void main(String[] args) {

		Trylockdemo t1 = new Trylockdemo("First");
		Trylockdemo t2 = new Trylockdemo("Second");
		Trylockdemo t3 = new Trylockdemo("Third");
		Trylockdemo t4 = new Trylockdemo("Forth");
		Trylockdemo t5 = new Trylockdemo("Fivth");
		Trylockdemo t6 = new Trylockdemo("Sixth");
		t1.start();
		t2.start();
		t4.start();
		t3.start();
		t5.start();
		t6.start();

	}

}
