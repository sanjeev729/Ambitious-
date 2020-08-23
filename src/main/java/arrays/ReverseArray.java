package arrays;

public class ReverseArray {

	public static void reverse(int arr[], int n, int k) {
		for (int i = 0; i < n; i += k) {
			int left = i;

			// to handle case when k is not multiple of n
			int right = Math.min(i + k - 1, n - 1);

			// reverse the sub-array [left, right]
			while (left < right) {
				int temp;
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}

		}
	}
	
	// Function to reverse every alternate sub-array 
	// formed by consecutive k elements
	static void reverse1(int arr[], int n, int k)
	{
	    // increment i in multiples of 2*k
	    for (int i = 0; i < n; i += 2*k)
	    {
	        int left = i;
	 
	        // to handle case when 2*k is not multiple of n
	        int right = Math.min(i + k - 1, n - 1);
	 
	        // reverse the sub-array [left, right]
	        while (left < right) {
				int temp;
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
	    }    
	}
	
	// Function to reverse every sub-array formed by 
	// consecutive k elements at m distance apart
	static void reverse2(int arr[], int n, int k, int m)
	{
	    // increment i in multiples of k + m
	    for (int i = 0; i < n; i += k + m)
	    {
	        int left = i;
	 
	        // to handle case when k + m is not multiple of n
	        int right = Math.min(i + k - 1, n - 1);
	 
	        // reverse the sub-array [left, right]
	        while (left < right) {
				int temp;
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
	    }
	}
	
	// Function to reverse every sub-array formed by 
	// consecutive k elements where k doubles itself 
	// with every sub-array.
	static void reverse3(int arr[], int n, int k)
	{
	    // increment i in multiples of k where value
	    // of k is doubled with each iteration
	    for (int i = 0; i < n; i += k/2)
	    {
	        int left = i;
	 
	        // to handle case when number of elements in 
	        // last group is less than k
	        int right = Math.min(i + k - 1, n - 1);
	 
	        // reverse the sub-array [left, right]
	        while (left < right) {
				int temp;
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
	 
	        // double value of k with each iteration
	        k = k*2;
	    }
	}

	// Driver code
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8,9,10 };
		//int k = 1;
		int k = 3;

		int n = arr.length;

		//reverse(arr, n, k);
		//reverse1(arr, n, k);
		//reverse2(arr, n, k,1);
		reverse3(arr, n, k);

		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");

	}
}
