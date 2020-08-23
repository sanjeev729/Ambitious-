package queue;

import java.util.LinkedList;
import java.util.Queue;

public class SusingQQ {

	static Queue<Integer> q1 = new LinkedList<Integer>();
	static Queue<Integer> q2 = new LinkedList<Integer>();

	// Function to push an item to the stack
	static void push(int x) {
		q1.add(x);
	}

	/* Function to pop an item from stack */
	static int pop() {
		if (q1.size() == 0)
			System.out.println("Underflow");
		while (q1.size() > 1) {
			q2.add(q1.poll());
		}
		int x = q1.poll();

		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		return x;
	}

	public static void main(String args[]) {
		/* Create a queue with items 1 2 3 */

		push(1);
		push(2);
		push(3);

		/* Dequeue items */
		System.out.print(pop() + " ");
		push(4);
		push(5);
		System.out.print(pop() + " ");
		System.out.print(pop() + " ");
		System.out.print(pop() + " ");
		System.out.print(pop() + " ");

	}

}
