package arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArrayGivenSum {

	static void subArraySum(int arr[], int n, int sum) {
		// create an empty map
		Map<Integer, Integer> map = new HashMap<>();

		// Maintains sum of elements so far
		int curr_sum = 0;
		int max_len = 0;
		for (int i = 0; i < n; i++) {
			// add current element to curr_sum
			curr_sum = curr_sum + arr[i];

			// if curr_sum is equal to target sum
			// we found a subarray starting from index 0
			// and ending at index i
			if (curr_sum == sum) {
				max_len = i + 1;
				System.out.println("Sum found between indexes from 0 to " + i);

				break;
			}

			// If curr_sum - sum already exists in map
			// we have found a subarray with target sum
			if (map.containsKey(curr_sum - sum)) {

				max_len = Math.max(max_len, i - map.get(curr_sum - sum));

				System.out.println("Sum found between indexes " + (map.get(curr_sum - sum) + 1) + " to " + i);

			} else
				map.put(curr_sum, i);
		}
		System.out.println("Length " + max_len);

		if (max_len == 0)
			System.out.println("No subarray with given sum exists");
	}
	
	
	// Returns true if arr[] has a subarray with zero sum
    static Boolean subArrayExists(int arr[])
    {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = 
                        new HashMap<Integer, Integer>();
         
        // Initialize sum of elements
        int sum = 0;     
         
        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        { 
            // Add current element to sum
            sum += arr[i];
             
            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash map
			if (arr[i] == 0 || sum == 0 || hM.get(sum) != null) 
				     /*
				      * If we consider all prefix sums, we can
					  * notice that there is a subarray with 0
					  * sum when : 1) Either a prefix sum repeats
					  * or 2) Or prefix sum becomes 0.
					  */
            return true;
             
            // Add sum to hash map
            hM.put(sum, i);
        } 
         
        // We reach here only when there is no subarray with 0 sum
        return false;
    }    

	public static void main(String[] args) {

		int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
		int n = arr.length;
		int sum = 0;

		subArraySum(arr, n, sum);

	}

}
