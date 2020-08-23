package queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU {

	Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	Deque<Integer> q = new LinkedList<Integer>();
	int frame_size;

	public LRU(int frame_size) {
		this.frame_size = frame_size;
	}

	public void refer(int val) {

		// not present in cache
		if (!map.containsKey(val)) {
			// cache is full
			if (q.size() == frame_size) {
				// delete least recently used element
				int last = q.poll();

				map.remove(last);
			}
		}

		// present in cache
		else
			q.remove(map.get(val));

		// update reference
		q.addFirst(val);
		map.put(val, val);

	}

	void display() {
		while (!q.isEmpty()) {
			System.out.print(q.pop() + " ");
		}

	}

	// Driver program to test above functions
	public static void main(String[] args) {
		LRU l = new LRU(4);

		l.refer(1);
		l.refer(2);
		l.refer(3);
		l.refer(1);
		l.refer(4);
		l.refer(5);
		l.display();

	}

}
