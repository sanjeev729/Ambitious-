package dp.knapsack.zeroOne;

public class MinimumSumDiffrence {

	// partition an array into two sets such that S1-S2 should be as minimum as
	// possible.
	static int minimumDiffrencePartition(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) { // get the sum of all elements
			sum = sum + arr[i];
		}
		boolean t[][] = new boolean[n + 1][sum + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0)
					t[i][j] = false;
				if (j == 0)
					t[i][j] = true;

			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j)
					t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
				else
					t[i][j] = t[i - 1][j];

			}
		}
		for (int j = sum / 2; j >= 0; j--) {
			if (t[n][j] == true) {

				return sum - 2 * j;
			}
		}
		return Integer.MAX_VALUE;

	}

	// Driver program to test above function
	public static void main(String args[]) {
		int arr1[] = new int[] { 2, 4, 5, 7 };
		int arr2[] = new int[] { 2, 3, 7 };
		System.out.println(minimumDiffrencePartition(arr1, arr1.length));
		System.out.println(minimumDiffrencePartition(arr2, arr2.length));
	}
}