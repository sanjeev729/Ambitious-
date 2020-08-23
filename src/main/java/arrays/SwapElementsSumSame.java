package arrays;

import java.util.HashSet;
import java.util.Set;
// works only for non-repeated values Arrys may contain same values but should not repeated
public class SwapElementsSumSame {

	/*
	 * 1. Find sum1(sum of small array elements) ans sum2 (sum of larger array
	 * elements). // time O(m+n) 2. Make a hashset for small array(here array1).
	 * 3. Calculate diff as (sum1-sum2)/2. 4. Run a loop for array2 for (int i
	 * equal to 0 to n-1) if (hashset contains (array2[i]+diff)) print
	 * array2[i]+diff and array2[i] set flag and break; 5. If flag is unset then
	 * there is no such kind of pair.
	 */

	// Function to calculate sum of elements of array
	static int getSum(int X[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += X[i];
		return sum;
	}

	static void findSwapValues(int A[], int B[]) {
		Set<Integer> s = new HashSet<Integer>();
		int sum1 = getSum(A, A.length);
		int sum2 = getSum(B, B.length);

		int diff = 0;

		if (sum1 > sum2)
			diff = (sum1 - sum2) / 2;
		else
			diff = (sum2 - sum1) / 2;

		for (int i = 0; i < A.length; i++)
			s.add(A[i]);

		for (int j = 0; j < B.length; j++) {
			if (s.contains(B[j] + diff)) {

				System.out.println(B[j] + " " +( B[j] + diff));
			}

		}

	}

	public static void main(String[] args) {
		int A[] = { 4, 6, 3 };

		int B[] = { 3, 2  };

		// Call to function
		findSwapValues(A, B);
	}

}
