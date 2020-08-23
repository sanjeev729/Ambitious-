package arrays;

import java.util.Stack;

public class NextGreatestElement {
	// O(N)
	// Main array will get altered

	private static void nextGreatest(int[] a, int length) {
		int max_from_right = a[length - 1];
		a[length - 1] = -1;

		for (int i = length - 2; i >= 0; i--) {

			if (max_from_right > a[i])
				a[i] = max_from_right;
			else {
				max_from_right = a[i];
				a[i] = -1;
			}
		}

	}
//This is next Greater element NOT next Greatest element
	//O(n)--Time
	//O(n)--Space
	static void printNGE(int arr[], int n) {
		int i = 0;
		Stack<Integer> s = new Stack<Integer>();

		int element, next;

		/* push the first element to stack */
		s.push(arr[0]);

		// iterate for rest of the elements
		for (i = 1; i < n; i++) {
			next = arr[i];

			if (s.isEmpty() == false) {

				// if stack is not empty, then
				// pop an element from stack
				element = s.pop();

				/*
				 * If the popped element is smaller than next, then a) print the
				 * pair b) keep popping while elements are smaller and stack is
				 * not empty
				 */
				while (element < next) {
					System.out.println(element + " --> " + next);
					if (s.isEmpty() == true)
						break;
					element = s.pop();
				}

				/*
				 * If element is greater than next, then push the element back
				 */
				if (element > next)
					s.push(element);
			}

			/*
			 * push next to stack so that we can find next greater for it
			 */
			s.push(next);
		}

		/*
		 * After iterating over the loop, the remaining elements in stack do not
		 * have the next greater element, so print -1 for them
		 */
		while (s.isEmpty() == false) {
			element = s.pop();
			next = -1;
			System.out.println(element + " -- " + next);
		}
	}

	public static void main(String[] args) {
		int a[] = { 10, 4, 5, 90, 120, 80};
		printNGE(a, a.length);
		System.out.println("------------");
		nextGreatest(a, a.length);
		for (int i : a)
			System.out.print(i + " ");

	}
}
