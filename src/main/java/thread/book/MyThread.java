package thread.book;

public class MyThread {

	private static volatile int Shared_Variable = 0;

	public static void main(String[] args) {
		new ReadOnChange().start();
		new Writer().start();
	}

	static class ReadOnChange extends Thread {
		@Override
		public void run() {
			int local_value = Shared_Variable;
			while (local_value < 5) {
				if (local_value != Shared_Variable) {
					System.out.println("Value changed for Shared_Variable :"
							+ Shared_Variable);
					local_value = Shared_Variable;
				}
			}
		}
	}

	static class Writer extends Thread {
		@Override
		public void run() {

			int local_value = Shared_Variable;
			while (Shared_Variable < 5) {
				System.out.println("changing the Shared_Variable to "
						+ (local_value + 1));
				Shared_Variable = ++local_value;
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}