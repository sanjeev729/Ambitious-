package binarysearch;

class FirstAndLastOccurence {

	static int firstOccurence(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		int result = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == key) {
				result = mid;
				end = mid - 1;
			} else if (arr[mid] < key)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return result;
	}

	static int lastOccurence(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		int result = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == key) {
				result = mid;
				start = mid + 1;
			} else if (arr[mid] < key)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return result;
	}

	// Driver program to test above methods
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 3, 3, 3, 7, 8, 9, 9 };
		int k = 3;
		int k2 = 9;
		System.out.println("Element's first occurence found at " + firstOccurence(arr, k));
		System.out.println();
		System.out.println("Element's last occurence found at " + lastOccurence(arr, k2));
		System.out.println("count of element " + (lastOccurence(arr, k) - firstOccurence(arr, k) + 1));
	}

}
