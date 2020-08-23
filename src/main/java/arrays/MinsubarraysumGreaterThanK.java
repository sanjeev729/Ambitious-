package arrays;

public class MinsubarraysumGreaterThanK {

	public MinsubarraysumGreaterThanK() {
		// TODO Auto-generated constructor stub
	}

	public static void printMinSubArrayWithSum(int[] array, int k) {

		int start = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;
		int currentSum = 0;
		while (end < array.length) {

			
			/*
			 * if (currentSum > k) for minimum subarray sum > k problem
			 * System.out.println("Length of  subarray " + "1");
			 */
			while (currentSum <= k && end < array.length) {
				currentSum += array[end++];
			}

			while (currentSum >= k && start < array.length) {

				if ((end - start) < min)
					min = end - start; // updating minimum length

				currentSum -= array[start++];

			}

		}

		/*
		 * if (start == 0 || end == array.length) { System.out.println(
		 * "No subarray exists with sum = " + k); return; }
		 */

		System.out.println(min);
	}

	public static void main(String[] args) {
		int[] array = { 5, 6, 1, 2, 4, 0 };
		int k = 10;
		printMinSubArrayWithSum(array, k);
	}

}
