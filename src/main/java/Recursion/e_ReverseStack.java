package Recursion;

import java.util.Arrays;
import java.util.Stack;

public class e_ReverseStack {

	private static void reverse(Stack<Integer> s) {
		if (s.size() == 1) {
			return;
		}

		int temp = s.peek();
		s.pop();

		reverse(s);
		insertAtEnd(s, temp);

	}

	private static void insertAtEnd(Stack<Integer> s, int element) {
		if (s.size() == 0) {
			s.push(element);
			return;
		}

		int temp = s.peek();
		s.pop();

		insertAtEnd(s, element);
		s.push(temp);
	}

	public static void main(String[] args) {
		Integer arr[] = { 9, 6, 1, 3, 5, 6, 7, 8 };
		Stack<Integer> s = new Stack<>();
		s.addAll(Arrays.asList(arr));
		System.out.println(s);
		reverse(s);
		System.out.println(s);

	}

}
