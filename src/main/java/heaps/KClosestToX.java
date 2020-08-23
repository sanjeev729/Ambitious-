package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestToX {

	static class Pair {
		Integer diff;
		Integer element;

		public Pair(int diff, int element) {
			this.diff = diff;
			this.element = element;
		}

	}

	static class PairComparator implements Comparator<Pair> {

		@Override
		public int compare(Pair p1, Pair p2) {

			return -p1.diff.compareTo(p2.diff);
		}

	}

	public static void kClosestToX(int arr[], int k, int x) {
		PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new PairComparator());

		for (int i = 0; i < arr.length; i++) {

			maxHeap.add(new Pair(Math.abs(x - arr[i]), arr[i]));

			if (maxHeap.size() > k)
				maxHeap.poll();
		}

		while (!maxHeap.isEmpty()) {
			System.out.print(maxHeap.peek().element + " ");
			maxHeap.poll();
		}
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 10, 2, 14, 4, 7, 6 };
		int k = 3;
		int x = 5;

		int arr1[] = new int[] { -10, -50, 20, 17, 80 };
		int k1 = 2;
		int x1 = 20;
		kClosestToX(arr, k, x);
		System.out.println();
		kClosestToX(arr1, k1, x1);

	}

}
