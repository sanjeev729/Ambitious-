package arrays;

// Java program to find triplets in a given 
// array whose sum is equal to given sum. 
import java.util.*;

public class TrippletSum {

	// function to print triplets with given sum
	static void findTriplets(int arr[], int n, int sum) {
		for (int i = 0; i < n - 1; i++) {
			// Find all pairs with sum equals to
			// "sum-arr[i]"
			HashSet<Integer> s = new HashSet<>();
			for (int j = i + 1; j < n; j++) {
				int x = sum - (arr[i] + arr[j]);
				if (s.contains(x))
					System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
				else
					s.add(arr[j]);
			}
		}
	}

	static boolean find3Numbers(int A[], int arr_size, int sum) {
		// Fix the first element as A[i]
		for (int i = 0; i < arr_size - 2; i++) {

			// Find pair in subarray A[i+1..n-1]
			// with sum equal to sum - A[i]
			HashSet<Integer> s = new HashSet<Integer>();
			int curr_sum = sum - A[i];
			for (int j = i + 1; j < arr_size; j++) {
				if (s.contains(curr_sum - A[j]) && curr_sum - A[j] != (int) s.toArray()[s.size() - 1]) {
					System.out.printf("Triplet is %d, %d, %d", A[i], A[j], curr_sum - A[j]);
					return true;
				}
				s.add(A[j]);
			}
		}

		// If we reach here, then no triplet was found
		return false;
	}

	// Driver code
	public static void main(String[] args) {
		int arr[] = { 0, -1, 2, -3, 1 };
		int sum = -2;
		int n = arr.length;
		findTriplets(arr, n, sum);
	}
}