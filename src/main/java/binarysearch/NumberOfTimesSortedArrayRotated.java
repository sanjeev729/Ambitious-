package binarysearch;

class NumberOfTimesSortedArrayRotated {

	static int numberOfTimesSortedArrayRotated(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int next = (mid + 1) % arr.length;
			int prev = (mid - 1 + arr.length) % arr.length;

			if (arr[mid] < arr[prev] && arr[mid] < arr[next]) {
				return mid;

			}

			else if (arr[mid] >= arr[start])
				start = mid + 1;
			else if (arr[mid] <= arr[end])
				end = mid - 1;
		}
		return -1;
	}

	// Driver program to test above methods
	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, };
		System.out.println("Element found at " + numberOfTimesSortedArrayRotated(arr));
	}

}
