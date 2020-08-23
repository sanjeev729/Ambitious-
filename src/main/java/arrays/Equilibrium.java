package arrays;

public class Equilibrium {
	int[] arr;

	public Equilibrium(int[] arr) {
		this.arr = arr;
	}

	public int getEquilibriumPoint() {

		for (int i = 0; i < arr.length - 1; i++) {
			int j;
			int lsum = 0, rsum = 0;

			for (j = i + 1; j < arr.length - 1; j++) {
				rsum = rsum + arr[j];
			}

			for (j = 0; j < i; j++) {
				lsum = lsum + arr[j];
			}

			if (rsum == lsum)
				return i;
		}

		return 0;

	}

	// o(n) approch , calculate total sum,then for each i value first subtract
	// that from sum then compare it with lsum then update the lsum for next
	// iteration

	public int getEquilibriumPointE() {
		int lsum = 0, rsum = 0;
		for (int i : arr)
			rsum += i;

		for (int i = 0; i < arr.length - 1; i++) {
			rsum = rsum - arr[i];
			if (rsum == lsum)
				return i;

			lsum = lsum + arr[i];

		}

		return -1;

	}

	public static void main(String[] args) {
		int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
		Equilibrium e = new Equilibrium(arr);
		System.out.println(e.getEquilibriumPointE());
	}

}
