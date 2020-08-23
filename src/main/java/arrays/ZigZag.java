package arrays;

import java.util.Arrays;

public class ZigZag {

	static int arr[] = new int[] { 4, 3, 7, 8, 6, 2, 1 };

	// Method for zig-zag conversion of array
	static void zigZag() {
		// Flag true indicates relation "<" is expected,
		// else ">" is expected. The first expected relation
		// is "<"
		boolean flag = true;

		int temp = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			if (flag) /* "<" relation expected */
			{
				/*
				 * If we have a situation like A > B > C, we get A > B < C by
				 * swapping B and C
				 */
				if (arr[i] > arr[i + 1]) {
					// swap
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}

			} else /* ">" relation expected */
			{
				/*
				 * If we have a situation like A < B < C, we get A < C > B by
				 * swapping B and C
				 */
				if (arr[i] < arr[i + 1]) {
					// swap
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			flag = !flag; /* flip flag */
		}
	}

	// Driver method to test the above function
	public static void main(String[] args) {
		zigZag();
		System.out.println(Arrays.toString(arr));
	}
}