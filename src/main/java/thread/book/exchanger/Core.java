package thread.book.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Core {
	public static void main(String[] args) {

		List<String> buffer1 = new ArrayList<>();
		List<String> buffer2 = new ArrayList<>();
		Exchanger<List<String>> exchanger = new Exchanger<>();

		Producer producer = new Producer(buffer1, exchanger);
		Consumer consumer = new Consumer(buffer2, exchanger);
		Thread threadProducer = new Thread(producer);
		Thread threadConsumer = new Thread(consumer);
		threadProducer.start();
		threadConsumer.start();
	}
}

class Producer implements Runnable {

	private List<String> buffer;
	private final Exchanger<List<String>> exchanger;

	public Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
		this.buffer = buffer;
		this.exchanger = exchanger;
	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j <5; j++) {
				String message = "Event " + ((i * 10) + j);
				System.out.println("Producer: " + message);
				buffer.add(message);
			}

		}
		try {
			buffer = exchanger.exchange(buffer);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Producer: " + buffer.size());

	}
}

class Consumer implements Runnable {

	private List<String> buffer;
	private final Exchanger<List<String>> exchanger;

	public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
		this.buffer = buffer;
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		
		/*for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 10; j++) {
				String message = "Event " + ((i * 10) + j);
				System.out.println("Consumer: " + message);
				buffer.add(message);
			}

		}*/

		try {
			buffer = exchanger.exchange(buffer);

			System.out.println("Consumer: " + buffer.size());
			for (int j = 0; j < 25; j++) {
				String message = buffer.get(0);
				System.out.println("Consumer: " + message);
				buffer.remove(0);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
