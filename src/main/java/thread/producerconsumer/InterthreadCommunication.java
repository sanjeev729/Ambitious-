package thread.producerconsumer;

public class InterthreadCommunication {
	int amount = 10000;

	synchronized void withdraw(int amount) {
		System.out.println("going to withdraw...");

		if (this.amount < amount) {
			System.out.println("Less balance; waiting for deposit...");
			try {
				wait();
			} catch (Exception e) {
			}
		}
		System.out.println("Amount before withdraw " + this.amount);
		this.amount -= amount;
		System.out.println("withdraw completed...");
		System.out.println("Amount after withdraw " + this.amount);
	}

	synchronized void deposit(int amount) {
		System.out.println("going to deposit...");
		System.out.println("Amount before deposit " + this.amount);
		this.amount += amount;
		System.out.println("deposit completed... ");
		System.out.println("Amount after deposit " + this.amount);
		notify();
	}

	public static void main(String args[]) {
		final InterthreadCommunication c = new InterthreadCommunication();
		new Thread() {
			public void run() {
				c.withdraw(15000);
			}
		}.start();
		new Thread() {
			public void run() {
				c.deposit(10000);
			}
		}.start();

	}
}
