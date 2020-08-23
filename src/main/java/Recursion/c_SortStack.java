package Recursion;

import java.util.Arrays;
import java.util.Stack;

public class c_SortStack {

	private static void sort(Stack<Integer> s) {
		if (s.size() == 1) {
			return;
		}

		int temp = s.peek();
		s.pop();

		sort(s);
		insert(s, temp);

	}

	private static void insert(Stack<Integer> s, int element) {
		if (s.size() == 0 || s.peek() <= element) {
			s.push(element);
			return;
		}

		int temp = s.peek();
		s.pop();

		insert(s, element);
		s.push(temp);
	}

	public static void main(String[] args) {
		Integer arr[] = { 9, 6, 1, 3, 5, 6, 7, 8 };
		Stack<Integer> s = new Stack<>();
		s.addAll(Arrays.asList(arr));
		System.out.println(s);
		sort(s);
		System.out.println(s);

	}

}
