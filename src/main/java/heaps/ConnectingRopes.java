package heaps;

import java.util.PriorityQueue;
/*
 * Time Complexity: Time complexity of the algorithm is O(nLogn) 
 * assuming that we use a O(nLogn) sorting algorithm. 
 * Note that heap operations like insert and extract take O(Logn) time.
 * 
 * */

public class ConnectingRopes {

	static int connectingRope(int arr[], int n) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			minHeap.add(arr[i]);
		}
		int minCost = 0;
		while (minHeap.size() >= 2) {
			int first = minHeap.poll();
			int second = minHeap.poll();
			int sum = first + second;
			minCost = minCost + sum;
			minHeap.add(sum);
		}

		return minCost;
	}

	public static void main(String args[]) {
		int arr[] = { 4, 3, 2, 6 };
		int size = arr.length;

		System.out.println("Total cost for connecting ropes is " + connectingRope(arr, size));
	}

}
