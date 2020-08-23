package sorting;

public class Bubble {

	static void bubbleSort(int a[]) {
		for (int i = 0; i < a.length - 1; i++) {
			int flag = 0;
			for (int j = 0; j < a.length - 1 - i; j++) {

				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
					flag = 1;
				}

			}
			if (flag == 0)
				return;
		}
	}

	private static void swap(int[] a, int i, int j) {
		a[i] = a[i] ^ a[j];
		a[j] = a[j] ^ a[i];
		a[i] = a[i] ^ a[j];

	}

	public static void main(String[] args) {

		int a[] = { 9, 2, 5, 1, 89, 5, 40 };
		bubbleSort(a);
		for (int ar : a)
			System.out.println(ar);

	}

}
