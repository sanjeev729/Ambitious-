package thread.book.exchanger;

import java.util.concurrent.Exchanger;

class MyThread extends Thread {

	Exchanger<Integer> exchanger;
	Integer numberToExchange;

	MyThread(Exchanger<Integer> exchanger, Integer message) {
		this.exchanger = exchanger;
		this.numberToExchange = message;
	}

	public void run() {
		try {
			System.out.println(this.getName() + " has value: " + numberToExchange);

			// exchange messages
			numberToExchange = exchanger.exchange(numberToExchange);

			System.out.println("After exchange " + this.getName() + " has value: " + numberToExchange);
		} catch (Exception e) {
		}
	}
}

public class ExchangerExample {

	public static void main(String[] args) {

		Exchanger<Integer> exchanger = new Exchanger<Integer>();

		Thread t1 = new MyThread(exchanger, new Integer(5));
		Thread t2 = new MyThread(exchanger, new Integer(10));
		// Thread t3 = new MyThread(exchanger, new Integer(14));
		// Thread t4 = new MyThread(exchanger, new Integer(15));

		t1.start();
		t2.start();
		// t3.start();
		// t4.start();
	}
}
