package binarysearch;

class BinarySearch {

	static int binarySearchIncreasing(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == key)
				return mid;

			else if (arr[mid] < key)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}

	static int binarySearchDecreasing(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == key)
				return mid;

			else if (arr[mid] < key)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

	static int sortingOrderNotKnown(int arr[], int key) {
		if (arr.length == 1) {
			if (arr[0] == key)
				return 0;
			else
				return -1;
		}
		if (arr.length >= 2) {
			if (arr[0] > arr[1])
				return binarySearchDecreasing(arr, key);
			else
				return binarySearchIncreasing(arr, key);
		}
		return -1;

	}

	// Driver program to test above methods
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int k = 6;
		int arr1[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int k1 = 8;
		System.out.println("Element found at " + binarySearchIncreasing(arr, k));
		System.out.println("Element found at " + binarySearchIncreasing(arr1, k1));

		System.out.println();
		System.out.println("Element found at " + binarySearchDecreasing(arr1, k1));
		System.err.println();
		System.out.println("Element found at " + sortingOrderNotKnown(arr, k));
		System.out.println("Element found at " + sortingOrderNotKnown(arr1, k1));
	}

}
