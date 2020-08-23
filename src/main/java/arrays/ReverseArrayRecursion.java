package arrays;

public class ReverseArrayRecursion {

	public ReverseArrayRecursion() {
		
	}

	public void reverseArray(int a[], int start, int end) {

		if (start > end)
			return;

		int temp = 0;
		temp = a[start];
		a[start] = a[end];
		a[end] = temp;
		reverseArray(a, start + 1, end - 1);

	}

	public void rotateArray(int a[], int k) {
		if (k == 0)
			return;
		// O(k*n) time
		// O(k) stack space
		int i, temp = a[0];
		for (i = 0; i < a.length - 1; i++)
			a[i] = a[i + 1];
		a[i] = temp;

		rotateArray(a, k - 1);

	}

	void leftRotate(int arr[], int d, int n) {
		reverseArray(arr, 0, d - 1);
		reverseArray(arr, d, n - 1);
		reverseArray(arr, 0, n - 1);
	}

	public static void main(String[] args) {

		ReverseArrayRecursion ra = new ReverseArrayRecursion();
		int a[] = { 1, 2, 3, 4, 5, 6 };

		int start = 0;
		int end = a.length - 1;

		// ra.reverseArray(a, start, end);
		//ra.rotateArray(a, 3);
		ra.leftRotate(a, 3, a.length);

		for (int a1 : a)
			System.out.print(a1);

	}

}
