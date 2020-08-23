package sorting;

public class Insertion {

	static void insertionSort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			int value = a[i];
			int hole = i;
			while (hole > 0 && a[hole - 1] > value) {
				a[hole] = a[hole - 1];
				hole = hole - 1;

			}

			a[hole] = value;
		}
	}

	public static void main(String[] args) {

		int a[] = { 9, 2, 5, 1, 89, 5, 40 };
		insertionSort(a);
		for (int ar : a)
			System.out.println(ar);

	}

}
