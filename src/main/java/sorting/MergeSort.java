package sorting;

public class MergeSort {

	static void mergeSort(int a[]) {
		int len = a.length;
		if (len < 2)
			return;

		int mid = len / 2;

		int[] left = new int[mid];
		int[] right = new int[len - mid];
		for (int i = 0; i < mid; i++)
			left[i] = a[i];
		for (int i = mid; i < len; i++)
			right[i - mid] = a[i];
		mergeSort(left);
		mergeSort(right);
		merge(left, right, a);

	}

	static void merge(int[] left, int[] right, int[] combine) {
		int l = left.length;
		int r = right.length;
		int i = 0, j = 0, k = 0;
		while (i < l && j < r) {
			if (left[i] < right[j]) {
				combine[k] = left[i];
				i++;
				k++;

			} else {

				combine[k] = right[j];
				j++;
				k++;
			}

		}
		while (i < l) {
			combine[k] = left[i];
			i++;
			k++;
		}
		while (j < r) {
			combine[k] = right[j];
			j++;
			k++;
		}

	}

	public static void main(String[] args) {

		int a[] = { 9, 2, 5, 1, 89, 5, 40 };
		mergeSort(a);
		for (int ar : a)
			System.out.println(ar);

	}

}
