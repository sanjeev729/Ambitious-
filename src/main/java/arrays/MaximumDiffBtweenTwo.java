package arrays;

public class MaximumDiffBtweenTwo {

	static int findMaxDiff(int arr[], int n) {
		//Time   O(n)
	   // Space  O(1)
		int diff = arr[1] - arr[0];
		int min = arr[0];
		for (int i = 1; i < n; i++) {

			if (arr[i] - min > diff)
				diff = arr[i] - min;
			if (arr[i] < min)
				min = arr[i];
		}
		return diff;
	}

	static int maxDiff(int arr[], int n) 
    {    //Time   O(n)
		// Space  O(n)
        // Create a diff array of size n-1. The array will hold
        //  the difference of adjacent elements
        int diff[] = new int[n - 1];
        for (int i = 0; i < n - 1; i++)
            diff[i] = arr[i + 1] - arr[i];
 
        // Now find the maximum sum subarray in diff array
        int max_diff = diff[0];
        for (int i = 1; i < n - 1; i++) 
        {
            if (diff[i - 1] > 0) 
                diff[i] += diff[i - 1];
            if (max_diff < diff[i])
                max_diff = diff[i];
        }
        return max_diff;
    }
	
	static int maxDiffE (int arr[], int n)
	{   //Time   O(n)
		// Space  O(1)
		
	    // Initialize diff, current sum and max sum
	    int diff = arr[1]-arr[0];
	    int curr_sum = diff;
	    int max_sum = curr_sum;
	 
	    for(int i=1; i<n-1; i++)
	    {
	        // Calculate current diff
	        diff = arr[i+1]-arr[i];
	 
	        // Calculate current sum
	        if (curr_sum > 0)
	           curr_sum += diff;
	        else
	           curr_sum = diff;
	 
	        // Update max sum, if needed
	        if (curr_sum > max_sum)
	           max_sum = curr_sum;
	    }
	 
	    return max_sum;
	}
	
	public static void main(String[] args) {
		int arr[] = { 7, 2, 7, 4, 8, 6, 7, 8, 1, 10 };

		System.out.println(findMaxDiff(arr, arr.length));
	}

}
