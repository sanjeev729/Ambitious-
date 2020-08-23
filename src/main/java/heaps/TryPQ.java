package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TryPQ {

	public static void main(String[] args) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				return -o1.compareTo(o2);
			}

		});

		minHeap.add(1);
		minHeap.add(2);
		minHeap.add(5);
		minHeap.add(4);
		minHeap.add(3);
		minHeap.add(2);
		
		maxHeap.add(1);
		maxHeap.add(2);
		maxHeap.add(5);
		maxHeap.add(4);
		maxHeap.add(3);
		maxHeap.add(2);
System.out.println("---------MIN HEAP ----------");
		System.out.print(minHeap);
		System.out.println(" "+minHeap.peek());
		minHeap.remove();
		System.out.print(minHeap);
		System.out.println(" "+minHeap.peek());

		minHeap.remove();
		System.out.print(minHeap);
		System.out.println(" "+minHeap.peek());
		
		minHeap.remove();
		System.out.print(minHeap);
		
		System.out.println(" "+minHeap.peek());
		System.out.println("-----MAX HEAP --------");
		System.out.print(maxHeap);
		System.out.println(" "+maxHeap.peek());
		maxHeap.remove();
		System.out.print(maxHeap);
		System.out.println(" "+maxHeap.peek());

		maxHeap.remove();
		System.out.print(maxHeap);
		System.out.println(" "+maxHeap.peek());
		
		maxHeap.remove();
		System.out.print(maxHeap);
		
		System.out.println(" "+maxHeap.peek());
	}

}
