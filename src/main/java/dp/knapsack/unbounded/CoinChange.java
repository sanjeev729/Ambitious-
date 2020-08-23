package dp.knapsack.unbounded;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {
	
	public static int totalWaysToMakeChange(int coins[],int sum,int n) {
		int t[][] = new int[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0)
					t[i][j] = 0;      //point of difference  (same as subset sum)
				if (j == 0)
					t[i][j] = 1;
			}
		}
		
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (coins[i - 1] <= j) {
					t[i][j] = t[i][j - coins[i - 1]] + t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][sum];
	}
	
	
	public static int minimunNumberOfCoins(int coins[],int sum,int n) {
		int t[][] = new int[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (j == 0)
					t[i][j] = 0;               //point of difference (not as subset sum)
				if (i == 0)
					t[i][j] = Integer.MAX_VALUE - 1;
			}
		}
		
		for (int j = 1; j < sum + 1; j++) {  //point of difference
			if (j % coins[0] == 0) {
				t[1][j] = j / coins[0];
			} else {
				t[1][j] = Integer.MAX_VALUE - 1;
			}
		}
		
		for (int i = 2; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (coins[i - 1] <= j) {
					t[i][j] = Math.min(1 + t[i][j - coins[i - 1]], t[i - 1][j]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][sum];
	}

	public int numberOfSolutions(int total, int coins[]) {
		int temp[][] = new int[coins.length + 1][total + 1];
		for (int i = 0; i <= coins.length; i++) {
			temp[i][0] = 1;
		}
		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (coins[i - 1] > j) {
					temp[i][j] = temp[i - 1][j];
				} else {
					temp[i][j] = temp[i][j - coins[i - 1]] + temp[i - 1][j];
				}
			}
		}
		return temp[coins.length][total];
	}
	
	

	/**
	 * Space efficient DP solution
	 */
	public static int numberOfSolutionsOnSpace(int total, int arr[]) {

		int temp[] = new int[total + 1];

		temp[0] = 1; // base condition
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (j >= arr[i]) {
					temp[j] += temp[j - arr[i]];
				}
			}
		}
		return temp[total];
	}

	// Q6.compute the minimum number of coins required to make that amount of
	// change.
	public static int makeChange(int money, int[] coins) {
		int[] cache = new int[money + 1];
		for (int i = 1; i <= money; i++) {
			int minCoins = Integer.MAX_VALUE;
			// Try removing each coin from the total
			// and see which requires the fewest
			// extra coins
			for (int coin : coins) {
				if (i - coin >= 0) {
					minCoins = Integer.min(minCoins, cache[i - coin] + 1);
				}
			}
			cache[i] = minCoins;
		}
		return cache[money];
	}

	/**
	 * This method actually prints all the combination. It takes exponential
	 * time.
	 */
	public void printCoinChangingSolution(int total, int coins[]) {
		List<Integer> result = new ArrayList<>();
		printActualSolution(result, total, coins, 0);
	}

	private void printActualSolution(List<Integer> result, int total, int coins[], int pos) {
		if (total == 0) {
			for (int r : result) {
				System.out.print(r + " ");
			}
			System.out.print("\n");
		}
		for (int i = pos; i < coins.length; i++) {
			if (total >= coins[i]) {
				result.add(coins[i]);
				printActualSolution(result, total - coins[i], coins, i);
				result.remove(result.size() - 1);
			}
		}
	}

	// Driver Function to test above function
	public static void main(String args[]) {
		int arr[] = { 1,2,3 };
		int m = arr.length;
		int n = 5;
		//System.out.println(makeChange(n, arr));
		System.out.println(minimunNumberOfCoins(arr, 5, 3));
	    System.out.println(totalWaysToMakeChange( arr,5,3));
	    System.out.println(numberOfSolutionsOnSpace(5, arr));

	}
}
