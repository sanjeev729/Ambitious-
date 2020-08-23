package dp;

public class SlidingWindow {

	public static void slidingWindow(int arr[], int n, int k) {
		int j, max;

		for (int i = 0; i <= n - k; i++) {

			max = arr[i];

			for (j = 1; j < k; j++) {
				if (arr[i + j] > max)
					max = arr[i + j];
			}
			System.out.print(max + " ");
		}
	}

	public static void slidingWindowKwithoutoverlap(int arr[], int n, int k) {
		int  max;
		for (int i = 0; i < n; i += k )
	    {   
			 max=arr[i];
			
	        int left = i;
	 
	        // to handle case when k + m is not multiple of n
	        int right = Math.min(i + k - 1, n - 1);
	 
	        // reverse the sub-array [left, right]
	        while (left < right) {
				if(arr[left]>max)
					max=arr[left];
				left++;
			
			}
	        System.out.println(max);
	    }
	}

	public static void main(String args[]) {
		int arr[] = { 1, 101, 2, 3, 100, 4 };
		slidingWindow(arr, arr.length, 3);
		System.out.println();
		slidingWindowKwithoutoverlap(arr, arr.length,2 );
	}
}
