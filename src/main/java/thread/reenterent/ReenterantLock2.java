package thread.reenterent;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterantLock2 {

	public static void main(String[] args) {
		ReentrantLock l = new ReentrantLock(true);
		l.lock();
		l.lock();
		System.out.println(l.getHoldCount());
		System.out.println(l.getQueueLength());
		l.unlock();
		System.out.println(l.isLocked());
		l.unlock();
		System.out.println(l.isLocked());

	}

}
