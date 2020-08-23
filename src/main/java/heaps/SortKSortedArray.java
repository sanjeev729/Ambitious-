package heaps;

import java.util.PriorityQueue;

public class SortKSortedArray {

	public static void sortKSorted(int arr[], int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		int temp[] = new int[arr.length];

		for (int i = 0; i < k + 1; i++) {

			minHeap.add(arr[i]);
		}

		int index = 0;
		for (int i = k + 1; i < arr.length; i++) {

			temp[index++] = minHeap.poll();
			minHeap.add(arr[i]);

		}

		while (!minHeap.isEmpty()) {
			temp[index++] = minHeap.poll();
		}

		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
	}

	public static void main(String[] args) {
		int arr[] = new int[] {  2, 6, 3, 12, 56, 8  };
		int k = 3;
		sortKSorted(arr, k);

	}

}
