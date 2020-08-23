package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargestSmallest {
	
	public static int kthLargest(int arr[], int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {

			minHeap.add(arr[i]);

			if (minHeap.size() > k)
				minHeap.poll();

		}
		return minHeap.peek();

	}
	
	public static PriorityQueue<Integer> kLargest(int arr[], int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {

			minHeap.add(arr[i]);

			if (minHeap.size() > k)
				minHeap.poll();

		}
		return minHeap;

	}

	public static int kthSmallest(int arr[], int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				return -o1.compareTo(o2);
			}

		});

		for (int i = 0; i < arr.length; i++) {

			maxHeap.add(arr[i]);

			if (maxHeap.size() > k)
				maxHeap.poll();

		}
		return maxHeap.peek();

	}
	
	public static PriorityQueue<Integer> kSmallest(int arr[], int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				return -o1.compareTo(o2);
			}

		});

		for (int i = 0; i < arr.length; i++) {

			maxHeap.add(arr[i]);

			if (maxHeap.size() > k)
				maxHeap.poll();

		}
		return  maxHeap;

	}
	



	public static void main(String[] args) {
		 int arr[] = new int[] { 12, 3, 5, 7, 19 }; 
	        int k = 2; 
	        System.out.println("K'th largest element is " + kthLargest(arr, k));
	        System.out.println("K largest elements " + kLargest(arr, k));
	        System.out.println("---------------------------");
	        System.out.println("K'th smallest element is " + kthSmallest(arr, k));
	        System.out.println("K smallest elements " + kSmallest(arr, k));
	        
	}

}
