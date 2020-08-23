package thread.reenterent;

public class Synchronizeddemo1 {

	public synchronized void  display(String name) {
		for (int i = 0; i < 10; i++)
			System.out.println(name);

	}

	public static void main(String[] args) {
		Synchronizeddemo1 sd = new Synchronizeddemo1();
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
