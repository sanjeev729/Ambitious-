package stack;

import java.util.Stack;

public class QusingSS {

	static Stack<Integer> stack1 = new Stack<>();
	static Stack<Integer> stack2 = new Stack<>();

	// Function to enqueue an item to the queue
	static void enQueue(int x) {
		stack1.push(x);
	}

	/* Function to dequeue an item from queue */
	static int deQueue() {
		int x;
		/* If both stacks are empty then error */
		if (stack1.isEmpty() && stack2.isEmpty()) {
			System.out.println("Q is empty");
			System.exit(0);
		}

		/*
		 * Move elements from stack1 to stack 2 only if stack2 is empty
		 */
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				x = stack1.pop();
				stack2.push(x);

			}
		}
		x = stack2.pop();
		return x;
	}

	public static void main(String args[]) {
		/* Create a queue with items 1 2 3 */
       
		enQueue(1);
		enQueue(2);
		enQueue(3);

		/* Dequeue items */
		System.out.print(deQueue() + " ");
		enQueue(4);
		enQueue(5);
		System.out.print(deQueue() + " ");
		System.out.println(deQueue() + " ");
	}

}
