package thread.reenterent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable<Object> {
	int num;

	public MyCallable(int num) {
		super();
		this.num = num;
	}

	@Override
	public Object call() throws Exception {

		System.out.println("Job started by " + Thread.currentThread().getName());
		int sum = 0;

		for (int i = 0; i < num; i++) {
			sum += i;
		}
		System.out.println("Job completed by " + Thread.currentThread().getName());
		return sum;
	}
}

public class Executerdemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyCallable cs[] = { new MyCallable(5), new MyCallable(10), new MyCallable(50) };

		//ExecutorService service = Executors.newFixedThreadPool(2);
		ExecutorService service = Executors.newCachedThreadPool();
		for (MyCallable m : cs) {
			Future<?> submit = service.submit(m);
			System.out.println(submit.get());
		}
		service.shutdown();

	}

}
