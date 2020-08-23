package dp.knapsack.zeroOne;

class SubsetSum {
	// Returns true if there is a subset of set[] with sun equal to given sum
	static boolean isSubsetSum(int arr[], int sum, int n) {

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
				if (arr[i - 1] <= j) {
					t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		return t[n][sum];
	}

	static int countSubsetsOfSum(int arr[], int sum, int n) {

		int t[][] = new int[n + 1][sum + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0)
					t[i][j] = 0;
				if (j == 0)
					t[i][j] = 1;
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		return t[n][sum];
	}

	public static void main(String args[]) {
		int arr[] = { 3, 34, 4, 12, 5, 3, 5 };
		int sum = 10;
		int n = arr.length;
		if (isSubsetSum(arr, sum, n) == true) {
			System.out.println("Found a subset with given sum");
			System.out.println(countSubsetsOfSum(arr, sum, n));
		} else
			System.out.println("No subset with given sum");
	}
}