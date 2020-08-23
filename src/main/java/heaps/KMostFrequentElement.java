package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KMostFrequentElement {

	static class Pair {
		Integer frequency;
		Integer element;

		public Pair(int frequency, int element) {
			this.frequency = frequency;
			this.element = element;
		}

	}

	static class PairComparator implements Comparator<Pair> {

		@Override
		public int compare(Pair p1, Pair p2) {

			return p1.frequency.compareTo(p2.frequency);
		}

	}

	public static void kMostFrequentElements(int arr[], int k) {
		PriorityQueue<Pair> minHeap = new PriorityQueue<>(new PairComparator());
		int hm[] = new int[20];
		for (int i = 0; i < arr.length; i++) {
			hm[arr[i]]++;
		}

		for (int i = 0; i < arr.length; i++) {

			minHeap.add(new Pair(hm[arr[i]], arr[i]));

			if (minHeap.size() > k)
				minHeap.poll();
		}

		while (!minHeap.isEmpty()) {
			System.out.print(minHeap.peek().element + " ");
			minHeap.poll();
		}
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 1, 4, 4, 5, 2, 6, 1 };
		int k = 2;

		int arr1[] = new int[] { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 };
		int k1 = 4;
		kMostFrequentElements(arr, k);
		System.out.println();
		kMostFrequentElements(arr1, k1);

	}

}
