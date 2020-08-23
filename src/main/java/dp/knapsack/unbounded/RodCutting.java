package dp.knapsack.unbounded;

public class RodCutting {

	// Naive approach but worst case O(2^n)
	/*
	 * Returns the best obtainable price for a rod of length n and price[] as
	 * prices of different pieces
	 */
	static int cutRod(int price[], int n) {
		if (n <= 0)
			return 0;
		int max_val = Integer.MIN_VALUE;

		// Recursively cut the rod in different pieces and
		// compare different configurations
		for (int i = 0; i < n; i++)
			max_val = Math.max(max_val, price[i] + cutRod(price, n - i - 1));

		return max_val;
	}

	// Dynamic programming approach O(n^2) but much efficient than the above one
	/*
	 * Returns the best obtainable price for a rod of length n and price[] as
	 * prices of different pieces
	 */

	static int rodCuttingDp(int price[], int rodLength) {
		int t[][] = new int[price.length + 1][rodLength + 1];

		for (int i = 0; i < price.length + 1; i++) {
			for (int j = 0; j < rodLength + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				}
			}
		}

		for (int i = 1; i < price.length + 1; i++) {
			for (int j = 1; j < rodLength + 1; j++) {
				if (i <= j) {
					t[i][j] = Math.max(price[i - 1] + t[i][j - i], t[i - 1][j]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		return t[price.length][rodLength];
	}

	static int cutRodE(int price[], int n) {
		int val[] = new int[n + 1];
		val[0] = 0;

		// Build the table val[] in bottom up manner and return
		// the last entry from the table
		for (int i = 1; i <= n; i++) {
			int max_val = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++)
				max_val = Math.max(max_val, price[j] + val[i - j - 1]);
			val[i] = max_val;
		}

		return val[n];
	}

	/* Driver program to test above functions */ 
	public static void main(String args[]) {
		int arr[] = { 1, 5, 8, 9, 10};
		int size = arr.length;
		System.out.println("Maximum Obtainable Value is " + cutRodE(arr, size));
		System.out.println("Maximum Obtainable Value is " + rodCuttingDp(arr, size));
	}
}
