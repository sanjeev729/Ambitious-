package thread.countdownlatch;

class CountDownLatchCustom {

	private volatile int count;

	public CountDownLatchCustom(int count) {
		super();
		this.count = count;
	}

	public synchronized void await() throws InterruptedException {
		if (count > 0)
			wait();
	}

	public synchronized void countDown() {
		count--;

		if (count == 0)
			notifyAll();
	}

}

class Read implements Runnable{
	CountDownLatchCustom latch;
	String name;
	
	public Read(CountDownLatchCustom latch) {
		super();
		this.latch = latch;
		
	}

	@Override
	public void run() {
		
		System.out.println("inside "+Thread.currentThread().getThreadGroup().getName()+" "+Thread.currentThread().getName());
		latch.countDown();
		
		
	}
	
	
}
public class CountDownLatchCustomTest{
	
public static void main(String[] args) {

	CountDownLatchCustom latch=new CountDownLatchCustom(5);
	
	Thread t1=new Thread(new Read(latch));
	Thread t2=new Thread(new Read(latch));
	Thread t3=new Thread(new Read(latch));
	Thread t4=new Thread(new Read(latch));
	Thread t5=new Thread(new Read(latch));
	
	
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	t5.start();
	
	try {
		latch.await();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Resume your services ");
	
}
	

	
	
	
	
	
}