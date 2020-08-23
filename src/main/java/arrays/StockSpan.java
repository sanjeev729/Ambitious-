package arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StockSpan {

	static void calculateSpan(int price[], int n, int S[]) {
		// O(n^2) Time
		// O(n) Space
		// Span value of first day is always 1
		S[0] = 1;

		// Calculate span value of remaining days by linearly checking
		// previous days
		for (int i = 1; i < n; i++) {
			S[i] = 1; // Initialize span value

			// Traverse left while the next element on left is smaller
			// than price[i]
			for (int j = i - 1; (j >= 0) && (price[i] >= price[j]); j--)
				S[i]++;
		}
	}

	static void calculateSpanE(int price[], int n, int S[]) {
		// O(n) Time
		// O(n)+ O(n) Space
		// Create a stack and push index of first element to it
		Stack<Integer> st = new Stack<>();
		st.push(0);

		// Span value of first element is always 1
		S[0] = 1;

		// Calculate span values for rest of the elements
		for (int i = n - 2; i >= 0; i--) {
			// Pop elements from stack while stack is not empty and top of
			// stack is smaller than price[i]
			while (!st.empty() && price[st.peek()] <= price[i])
				st.pop();
			int j = price.length;
			// If stack becomes empty, then price[i] is greater than all
			// elements
			// on left of it, i.e., price[0], price[1],..price[i-1]. Else
			// price[i]
			// is greater than elements after top of stack
			S[i] = (st.empty()) ? (i) : (i - st.peek());

			// Push this element to stack
			st.push(i);
		}
	}

	// A utility function to print elements of array
	static void printArray(int arr[]) {
		System.out.print(Arrays.toString(arr));
	}

	static void printTallest(int arr[]) {
		System.out.print(Arrays.toString(arr));
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		int price[] = { 5, 4, 3, 1, 2 };
		int price2[] = { 2, 1, 3, 4, 5 };
		int n = price.length;

		int S[] = new int[n];

		// Fill the span values in array S[]
		calculateSpanE(price2, n, S);

		// print the calculated span values
		printArray(S);
	}

}
