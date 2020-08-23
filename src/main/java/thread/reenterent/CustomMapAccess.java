package thread.reenterent;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class RWDictionary {
	private final Map<String, Data> m = new TreeMap<>();
	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private final Lock r = rwl.readLock();
	private final Lock w = rwl.writeLock();

	public Data get(String key) throws InterruptedException {
		r.lock();
		System.out.println("read starts");
		try {
			Thread.sleep(1000);

			return m.get(key);
		} finally {
			System.out.println("read ends");
			r.unlock();

		}
	}

	public String[] allKeys() throws InterruptedException {
		r.lock();
		System.out.println("read starts");
		try {
			Thread.sleep(1000);
			return m.keySet().toArray(new String[] {});
		} finally {
			System.out.println("read ends");
			r.unlock();
		}
	}

	public Data put(String key, Data value) throws InterruptedException {
		w.lock();
		System.out.println("write starts");
		try {
			Thread.sleep(1000);
			return m.put(key, value);
		} finally {
			System.out.println("write ends");
			w.unlock();
		}
	}

	public void clear() {
		w.lock();
		System.out.println("write starts");
		try {
			m.clear();
		} finally {
			System.out.println("write ends");
			w.unlock();

		}
	}
}

public class CustomMapAccess {
	public static void main(String[] args) throws InterruptedException {
		RWDictionary rwd = new RWDictionary();
		Thread tr1 = new Thread(new Read(rwd));
		Thread tr2 = new Thread(new Read(rwd));
		Thread tr3 = new Thread(new Read(rwd));
		Thread tr4 = new Thread(new Read(rwd));
		Thread t2 = new Thread(new Write(rwd));
		Thread t3 = new Thread(new Write1(rwd));
		// Thread t3 = new Thread(new WriteB());
		
		t2.start();
		t3.start();
		Thread.sleep(10);
		tr1.start();
		tr2.start();
		tr3.start();
		tr4.start();

	}
}

class Read implements Runnable {
	RWDictionary rwd;

	public Read(RWDictionary rwd) {
		super();
		this.rwd = rwd;
	}

	public void run() {
		try {
			for (String s : rwd.allKeys())
				System.out.println(s);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Write implements Runnable {
	RWDictionary rwd;

	public Write(RWDictionary rwd) {
		super();
		this.rwd = rwd;
	}

	public void run() {
		try {
			rwd.put("Sanjeev", new Data(1, "sanjeev"));
			rwd.put("Sachin", new Data(2, "sachin"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class Write1 implements Runnable {
	RWDictionary rwd;

	public Write1(RWDictionary rwd) {
		super();
		this.rwd = rwd;
	}

	public void run() {

		try {
			rwd.put("Kumar", new Data(3, "kumar"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class WriteB implements Runnable {

	public void run() {

		System.out.println(Thread.currentThread().getName());
	}
}
