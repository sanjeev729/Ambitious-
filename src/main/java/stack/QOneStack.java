package stack;

import java.util.Stack;

public class QOneStack {
	Stack<Integer> s = new Stack<Integer>();

	/* Function to enqueue an item to queue */
	void enQueue(int x) {
		s.push(x);
	}

	/* Function to dequeue an item from queue */
	int deQueue() {
		int x, res = 0;
		/* If the stacks is empty then error */
		if (s.isEmpty()) {
			System.out.println("Q is Empty");
			System.exit(0);
		}
		// Check if it is a last element of stack
		else if (s.size() == 1) {
			return s.pop();
		} else {
			/* pop an item from the stack1 */
			x = s.pop();

			/* store the last dequeued item */
			res = deQueue();

			/* push everything back to stack1 */
			s.push(x);
			return res;
		}
		return 0;
	}

	/* Driver function to test above functions */
	public static void main(String[] args) {
		/* Create a queue with items 1 2 3 */
		QOneStack q = new QOneStack();

		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);

		/* Dequeue items */
		System.out.print(q.deQueue() + " ");
		System.out.print(q.deQueue() + " ");
		System.out.print(q.deQueue() + " ");

	}

}
