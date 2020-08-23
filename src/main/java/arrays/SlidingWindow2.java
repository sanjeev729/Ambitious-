package arrays;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindow2 {

	public SlidingWindow2() {

	}

	public static List<Integer> maxElement(int[] arr, int k) {
		Deque<Integer> dq = new LinkedList<Integer>();
		List<Integer> l = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
            //Remove element out of window
			if (!dq.isEmpty() && dq.peekFirst() <= i - k)
				dq.pollFirst();
           //Dq is in descending order
			while (!dq.isEmpty() && arr[i] > arr[dq.peekLast()]) //change this for min in subarry
				dq.pollLast();
			//Push the current element to the deque
			dq.addLast(i);
            
			if (i >= k - 1)  //reached the total window size //put sum logic inside this after commenting while line code
				//put the first element of queue in list as max element in current window 
				l.add(arr[dq.peekFirst()]);
		}

		return l;

	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 1,4, 5, 2, 3, 6 };
		int k = 3;
		List<Integer> l = maxElement(arr, k);
		Iterator<Integer> t = l.iterator();
		while (t.hasNext()) {
			System.out.print(t.next() + " ");

		}
		;

	}
}
