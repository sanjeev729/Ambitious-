package thread.reenterent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Trylockdemo2 extends Thread {
	public static ReentrantLock l = new ReentrantLock(true);

	public Trylockdemo2(String tname) {
		super(tname);
	}

	public void run() {
		do {
			try {
				if (l.tryLock(20000, TimeUnit.MILLISECONDS)) {
					System.out.println(Thread.currentThread().getName() + "Got the lock Inside");

					Thread.sleep(10000);

					l.unlock();
                   break;
				} else
					System.out.println(Thread.currentThread().getName() + "Try next time");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (true);
	}

	public static void main(String[] args) {

		Trylockdemo2 t1 = new Trylockdemo2("First");
		Trylockdemo2 t2 = new Trylockdemo2("Second");
		Trylockdemo2 t3 = new Trylockdemo2("Third");
		Trylockdemo2 t4 = new Trylockdemo2("Forth");
		Trylockdemo2 t5 = new Trylockdemo2("Fivth");
		Trylockdemo2 t6 = new Trylockdemo2("Sixth");
		t1.start();
		t2.start();
		t4.start();
		t3.start();
		t5.start();
		t6.start();

	}

}
