package arrays;

public class PrefixSum {

	public static void seggregate01(int[] a) {

		int i = 0;
		int j = a.length - 1;

		while (i != j) { // until when
			if (a[i] == 0) {
				i++;
			} else if (a[j] == 1) { // if not then
				j--;
			}
			swap(i, j, a); // for some operation
		}
	}

	public static void seggregateEvenOdd(int[] a) {

		int i = 0;
		int j = a.length - 1;

		while (i != j) { // until when
			if (a[i] % 2 == 0) {
				i++;
			} else if (a[j] % 2 != 0) { // if not then
				j--;
			}
			swap(i, j, a); // for some operation
		}
	}

	public static int equilibriumPoint(int[] a) {
		int i = 0;
		int j = a.length - 1;
		int sum = 0;
		while (i != j) {

			if (sum >= 0) {
				sum -= a[j];
				j--;
			} else {
				sum += a[i];
				i++;
			}
		}

		return sum == 0 ? i : -1;

	}

	public static int Partitionpoint(int[] a) {
		int i = 0;
		int j = a.length - 1;
		int sum = 0;
		int pindex = a.length - 1;
		while (i != j) {

			if (a[j] >= a[pindex]) {

				j--;
			} else if (a[i] < a[pindex]) {

				i++;
			}
			swap(i, j, a);
		}

		return sum == 0 ? i : -1;

	}

	private static void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int arr[] = { 4, 1, 2, 2, 3 };

		// seggregate01(arr);
		// seggregateEvenOdd(arr);
		//Partitionpoint(arr);
	//	System.out.println(Arrays.toString(arr));
	 System.out.println(equilibriumPoint(arr));
		// System.out.println(Arrays.toString(arr));
	}
}
