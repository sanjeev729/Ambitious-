package Recursion;

import java.util.Arrays;
import java.util.Stack;

public class d_DeleteMiddleElementStack {

	private static void deleteFromStack(Stack<Integer> s, int k) {
		if (k == 1) {
			s.pop();
			return;
		}

		int temp = s.peek();
		s.pop();

		deleteFromStack(s, k - 1);
		s.push(temp);

	}

	private static Stack<Integer> deleteUtility(Stack<Integer> s) {
		if (s.size() == 0) {
			return s;
		}

		int mid = s.size() / 2 + 1;

		deleteFromStack(s, mid);
		return s;
	}

	public static void main(String[] args) {
		Integer arr[] = { 9, 6, 1, 3, 5, 7, 8 };
		Stack<Integer> s = new Stack<>();
		s.addAll(Arrays.asList(arr));
		System.out.println(s);
		System.out.println(deleteUtility(s));

	}

}
