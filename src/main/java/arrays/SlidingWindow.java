/**
 * 
 */
package arrays;

/**
 * @author skpal
 *
 */
public class SlidingWindow {

	/**
	 * @param args
	 */

	public static int slidingWindow(int[] arr, int k) {
		int wsum = 0;
		
		// compute the initial window sum
		for (int i = 0; i < k; i++) {
			wsum = wsum + arr[i];
		}
		
		int maxsum =wsum;
	    // Compute sums of remaining windows by 
        // removing first element of previous 
        // window and adding last element of  
        // current window.
		for (int j = k; j < arr.length; j++) {
			wsum=wsum - arr[j - k] + arr[j];
			maxsum = Math.max(maxsum,wsum );
		}

		return maxsum;
	}
	static int smallestSubWithSum(int arr[],int n, int x) 
	{
		// Initialize current
		// sum and minimum length
		int curr_sum = 0, min_len = n + 1;

		// Initialize starting
		// and ending indexes
		int start = 0, end = 0;
		while (end < n) {
			// Keep adding array
			// elements while current
			// sum is smaller than x
			while (curr_sum <= x && end < n) {
				// Update minimum
				// length if needed
				if (curr_sum == x) {
					if (end - start < min_len)
						min_len = end - start;
				}

				// Ignore subarrays with
				// negative sum if x is
				// positive.
				if (curr_sum <= 0 && x > 0) {
					start = end;
					curr_sum = 0;
				}

				curr_sum += arr[end++];
			}

			// If current sum becomes
			// greater than x.
			while (curr_sum > x && start < n) {
				// remove starting elements
				curr_sum -= arr[start++];
			}
		}
		return min_len;
	}

	public static void main(String[] args) {
	int	arr[] = {6, 4, 45, 6,10, 19};
	
	System.out.println(slidingWindow(arr, 4));
	System.out.println(smallestSubWithSum(arr,arr.length, 10));
	
	}

}
