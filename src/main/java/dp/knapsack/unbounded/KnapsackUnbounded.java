package dp.knapsack.unbounded;

public class KnapsackUnbounded {
	
	// Returns the maximum value that can be put in a knapsack of capacity W (0/1 Knapsack  : multiple occurrences of items are not allowed)
	static int knapSack01(int wt[], int val[], int W, int n) {
		int t[][] = new int[n + 1][W + 1];

		for (int i = 0; i < n + 1; i++) {              //initialization
			for (int j = 0; j < W + 1; j++) {     
				if (i == 0 || j == 0)
					t[i][j] = 0;
			}
		}

		for (int i = 1; i < n + 1; i++) {              //choice diagram
			for (int j = 1; j < W + 1; j++) {
				if (wt[i - 1] <= j)
					t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
				else
					t[i][j] = t[i - 1][j];
			}
		}

		return t[n][W];
	}
	
	
	// Returns the maximum value that can be put in a knapsack of capacity W (unbounded Knapsack : multiple occurrences of items are allowed )
		static int knapSackUnbounded(int wt[], int val[], int W, int n) {
			int t[][] = new int[n + 1][W + 1];

			for (int i = 0; i < n + 1; i++) {              //initialization
				for (int j = 0; j < W + 1; j++) {     
					if (i == 0 || j == 0)
						t[i][j] = 0;
				}
			}

			for (int i = 1; i < n + 1; i++) {              //choice diagram
				for (int j = 1; j < W + 1; j++) {
					if (wt[i - 1] <= j)
						t[i][j] = Math.max(val[i - 1] + t[i][j - wt[i - 1]], t[i - 1][j]);
					else
						t[i][j] = t[i - 1][j];
				}
			}

			return t[n][W];
		}

	// Driver program to test above function
	public static void main(String args[]) {
		int val[] = new int[] { 1, 4, 5, 7 };
		int wt[] = new int[] { 1, 3, 4, 5 };
		int W = 7;
		int n = val.length;
		System.out.println(knapSack01( wt, val,W, n));
		System.out.println(knapSackUnbounded( wt, val,W, n));
	}
}