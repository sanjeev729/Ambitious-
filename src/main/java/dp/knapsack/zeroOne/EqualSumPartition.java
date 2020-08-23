package dp.knapsack.zeroOne;

public class EqualSumPartition {

	// check if an array can be divided in two equal sets
	static boolean equalSumPartition(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) { // get the sum of all elements
			sum = sum + arr[i];
		}
		
		if (sum % 2 != 0)   //sum of all elements should be divisible by 2 then the chances are that we can divide,if not return false
			return false;

		else
			return SubsetSum.isSubsetSum(arr, sum / 2, n);  // if we can get a single set of sum equal to sum of all elements/2 the set of remaining elements will be sum of all elements/2 
	}

	// Driver program to test above function
	public static void main(String args[]) {
		int arr1[] = new int[] { 2, 4, 5, 7 };
		int arr2[] = new int[] { 2, 3, 7 };
		System.out.println(equalSumPartition(arr1, arr1.length));
		System.out.println(equalSumPartition(arr2, arr2.length));
	}
}