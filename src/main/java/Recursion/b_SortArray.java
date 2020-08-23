package Recursion;

public class b_SortArray {

	private static void sortArray(int[] arr, int n) {
		if (n == 1) {
			return;
		}

		int temp = arr[n - 1];

		sortArray(arr, n - 1);
		insert(arr, temp, n - 1);

	}

	private static void insert(int[] arr, int temp,int n) {
		if (n == 0 || arr[n - 1] <= temp) {
			arr[n] = temp;
			return ;
		}

		int temp1 = arr[n - 1];

		insert(arr, temp1, n - 1);

	}

	public static void main(String[] args) {
		int arr[] = { 9, 6, 1, 3, 5, 6, 7, 8 };

		sortArray(arr, arr.length);
		for (int i : arr)
			System.out.print(i + " ");

	}

}
