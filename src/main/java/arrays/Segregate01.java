package arrays;

public class Segregate01 {

	void sortBinaryArray(int a[], int n) {
		int j = 0;
		for (int i = 0; i < n; i++) {

			// if number is smaller than 1
			// then swap it with j-th number
			if (a[i] < 1) {
				int temp = a[i]; // swap(a[i], a[j])
				a[i] = a[j];
				a[j] = temp;
				j++;
			}
		}
	}

	public static void main(String[] args) {
		Segregate01 seg = new Segregate01();
		int arr[] = new int[] { 0, 1, 0, 1, 1, 1, 0, 0 };
		int i, arr_size = arr.length;

		seg.sortBinaryArray(arr, arr_size);

		System.out.print("Array after segregation is ");
		for (i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
