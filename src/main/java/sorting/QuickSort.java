package sorting;

public class QuickSort {

	static void quickSort(int a[], int start, int end) {

		if (start < end) {

			int pindex = partition(a, start, end);

			quickSort(a, start, pindex - 1);
			quickSort(a, pindex + 1, end);

		}

	}

	static int partition(int[] a, int start, int end) {

		int pivot = a[end];
		int pindex = start;

		for (int i = start; i < end; i++) {
			if (a[i] <= pivot) {

				int temp = a[i];
				a[i] = a[pindex];
				a[pindex] = temp;

				pindex++;

			}
		}
		swap(a, pindex, end);
		return pindex;

	}

	private static void swap(int[] a, int i, int j) {
		a[i] = a[i] ^ a[j];
		a[j] = a[j] ^ a[i];
		a[i] = a[i] ^ a[j];

	}

	public static void main(String[] args) {

		int a[] = { 9, 2, 5, 1, 89, 5, 40 };
		quickSort(a, 0, a.length - 1);
		for (int ar : a)
			System.out.println(ar);

	}

}
