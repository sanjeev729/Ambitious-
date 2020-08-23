package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {

	public double[] getmedians(int arr[]) {
		
		PriorityQueue<Integer> highers = new PriorityQueue<>();
		PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return -1 * a.compareTo(b);
			}
		});

		double medians[] = new double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			addnumber(arr[i],lowers, highers);
			rebalance(lowers,highers );
			medians[i] = getMedian(lowers,highers);
		}

		return medians;

	}

	private void addnumber(int data, PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers) {
		if (lowers.size() == 0 || data < lowers.peek())
			lowers.add(data);
		else
			highers.add(data);

	}
	
	private void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		if (lowers.size() > highers.size() && (lowers.size() - highers.size()) > 1)
			highers.add(lowers.poll());
		if (highers.size() > lowers.size() && (highers.size() - lowers.size()) > 1)
			lowers.add(highers.poll());

	}

	public double getMedian(PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers) {

		if (lowers.size() == highers.size())
			return ((double) (lowers.peek() + highers.peek())) / 2;
		else if (lowers.size() > highers.size())
			return lowers.peek();
		else
			return highers.peek();

	}

	public static void main(String[] args) {
		RunningMedian hp = new RunningMedian();
		int[] arr = {5, 15, 10, 20, 3};

		double[] db = hp.getmedians(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(db[i]);

		}

	}
}
