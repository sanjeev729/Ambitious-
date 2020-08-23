package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestToOrigin {

	static class Pair {
		Integer z;
		Integer x;
		Integer y;

		public Pair(int z, int x, int y) {
			this.z = z;
			this.x = x;
			this.y = y;
		}

	}

	static class PairComparator implements Comparator<Pair> {

		@Override
		public int compare(Pair p1, Pair p2) {

			return -p1.z.compareTo(p2.z);
		}

	}

	public static void kClosestToOrigin(int arr[][], int k) {
		PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new PairComparator());

		for (int i = 0; i < arr.length; i++) {

			maxHeap.add(new Pair(arr[i][0] * arr[i][0] + arr[i][1] * arr[i][1], arr[i][0], arr[i][1]));

			if (maxHeap.size() > k)
				maxHeap.poll();
		}

		while (!maxHeap.isEmpty()) {
			System.out.println(maxHeap.peek().x + " " + maxHeap.peek().y);
			maxHeap.poll();
		}
	}

	public static void main(String[] args) {
		int arr[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int k = 2;

		int arr1[][] = { { 1, 3 }, { -2, 2 } };
		int k1 = 1;
		kClosestToOrigin(arr, k);
		System.out.println();
		kClosestToOrigin(arr1, k1);

	}

}
