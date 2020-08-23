package sorting;

public class Selection {

	static void selectionSort(int a[]) {
		for (int i = 0; i < a.length - 1; i++) {
			int min = i;

			for (int j = i + 1; j < a.length; j++) {

				if (a[j] < a[min]) {
					min = j;
				}

			}

			swap(a, min, i);

		}
	}

	private static void swap(int[] a, int i, int j) {
		a[i] = a[i] ^ a[j];
		a[j] = a[j] ^ a[i];
		a[i] = a[i] ^ a[j];

	}

	public static void main(String[] args) {

		int a[] = { 9, 2, 5, 1, 89, 5, 40 };
		selectionSort(a);
		for (int ar : a)
			System.out.println(ar);

	}

}
